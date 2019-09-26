package com.robert.demo.service.impl;

import com.robert.demo.entity.Document;
import com.robert.demo.service.DocumentService;
import io.searchbox.client.JestClient;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Get;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author changyuwei
 * @date 2019-09-11
 */
@Service
@ConfigurationProperties(prefix = "spring.elasticsearch")
public class DocumentServiceImpl implements DocumentService {
    /**
     * 必须小写
     */
    private String indices;

    /**
     * 必须小写
     */
    private String type;

    public void setIndices(String indices) {
        this.indices = indices;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Resource
    JestClient jestClient;

    @Override
    public Document getById(String id) throws IOException {
        Get get = new Get.Builder(indices, id).type(type).build();
        DocumentResult result = this.jestClient.execute(get);
        if (result != null) {
            return result.getSourceAsObject(Document.class);
        }
        return null;
    }

    @Override
    public List<Document> search(String query) throws IOException {

        Search search = new Search.Builder(query).addIndex(indices).addType(type).build();
        SearchResult result = this.jestClient.execute(search);
        if (result != null) {
            List<SearchResult.Hit<Document, Void>> hits = result.getHits(Document.class);
            if (!hits.isEmpty()) {
                return hits.stream().map(o -> o.source).collect(Collectors.toList());
            }
        }
        return null;
    }
}
