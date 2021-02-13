package crio.xmeme.persist;

import crio.xmeme.model.Meme;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemeRepository extends PagingAndSortingRepository<Meme, Integer> {

    @Query(value = "SELECT * FROM memes meme WHERE meme.name = ?1 and meme.caption = ?2 and meme.url = ?3", nativeQuery = true)
    public Meme findMeme(String name, String caption, String url);

    public default List<Meme> getMemes(int page, int pageSize) {
        Pageable pageable =  PageRequest.of(page, pageSize, Sort.by("id").descending());
        return findAll(pageable).toList();
    }
}
