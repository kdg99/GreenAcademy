package kr.co.farmstory.dao;

import java.util.List;

import kr.co.farmstory.vo.ArticleVO;
import kr.co.farmstory.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ArticleDAO {
    public int insertArticle(ArticleVO vo);
    public ArticleVO selectArticle(int no);
    public List<ArticleVO> selectArticles(int start, String cate, int amount);
    public int updateArticle(ArticleVO vo);
    public int deleteArticle(int no);

    //조회수
    public int updateArticleHit(int no);

    //파일
    public int insertFile(FileVO vo);
    public FileVO selectFile(int fno);
    public int updateFileDownload(int fno);

    //페이징
    public int selectCountTotal(String cate);

    //댓글
    public void insertComment(ArticleVO vo);
    public void deleteComments(int no);
    public List<ArticleVO> selectComments(int no, int start, int amount);
    public void increaseArticleComment(int no);
    public void decreaseArticleComment(int no);

}
