package com.baizhi.controller;

import com.baizhi.entity.Poetry;
import com.baizhi.entity.Poets;
import com.baizhi.service.PoetryService;
import com.baizhi.util.Page;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wltea.analyzer.lucene.IKAnalyzer;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/poetry")
public class PoetryController {
    @Autowired
    private PoetryService poetryService;

    /**
     * 诗句查询
     */
    @RequestMapping("/queryVerse")
    public String queryVerse(String verse, int nowPage, int pageSize, HttpServletRequest request) throws IOException, ParseException, InvalidTokenOffsetsException {

        FSDirectory fsDirectory = FSDirectory.open(Paths.get("D:\\index\\01"));
        IndexReader indexReader = DirectoryReader.open(fsDirectory);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        // 查询解析器对象  作用 解析查询表达式  域名:条件
        // 参数一: 域名(默认域)
        QueryParser queryParser = new QueryParser("content", new IKAnalyzer());

        Query query = null;

        query = queryParser.parse(verse);
        //query = queryParser.parse("author:李白");
        //query = queryParser.parse("author:武则天");
        //分页
        TopDocs topDocs=null;

        if(nowPage==1){
            //第一次当前页为1
            topDocs=indexSearcher.search(query, pageSize);
        }else if(nowPage>1){
            //获取之前页的所有记录 并获取最后一条记录
            topDocs=indexSearcher.search(query,(nowPage-1)*pageSize);
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            ScoreDoc sd = scoreDocs[scoreDocs.length-1];
            topDocs = indexSearcher.searchAfter(sd, query, pageSize);
        }
        //高亮
        // 创建高亮器对象
        Scorer scorer = new QueryScorer(query);
        // 默认高亮样式 加粗
        // 使用自定义的高亮样式
        Formatter formatter = new SimpleHTMLFormatter("<span style=\"color:red\">","</span>");
        Highlighter highlighter = new Highlighter(formatter,scorer);

        //总记录数
        int totalHits = topDocs.totalHits;
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;

        List<Poetry> poetryList = new ArrayList<>();
        for (ScoreDoc scoreDoc : scoreDocs) {
            int docID = scoreDoc.doc;
            Document document = indexReader.document(docID);

            Poetry poetry = new Poetry();
//            poetry.setId(Integer.parseInt(document.get("id")));
//            poetry.setTitle(document.get("title"));
//            poetry.setContent(document.get("content"));
            Poets poets = new Poets();
//            poets.setName(document.get("author"));
//            poetry.setPoets(poets);
            String author = highlighter.getBestFragment(new IKAnalyzer(),"content",document.get("author"));
            if(author!=null){
                poets.setName(author);
                poetry.setPoets(poets);
            }else{
                poets.setName(document.get("author"));
                poetry.setPoets(poets);
            }
//标题
            String title = highlighter.getBestFragment(new IKAnalyzer(), "content",document.get("title"));
            if(title!=null){
                poetry.setTitle(title);
            }else{
                poetry.setTitle(document.get("title"));
            }
//内容
            String content = highlighter.getBestFragment(new IKAnalyzer(), "content",document.get("content"));
            if(content!=null){
                poetry.setContent(content);
            }else{
                poetry.setContent(document.get("content"));
            }

            poetryList.add(poetry);
        }
        indexReader.close();
        Page page = new Page();
        page.setPageIndex(nowPage);
        page.setPageSize(pageSize);
        int i = page.pageCounts(totalHits);
        page.setPageCount(i);
        request.setAttribute("list",poetryList);
        request.setAttribute("verse",verse);
        request.setAttribute("page",page);
        return "result";
    }
}
