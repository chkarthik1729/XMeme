package crio.xmeme.service;

import crio.xmeme.exception.MemeAlreadyExistsException;
import crio.xmeme.exception.MemeConstraintViolationException;
import crio.xmeme.exception.MemeNotFoundException;
import crio.xmeme.model.Meme;
import crio.xmeme.persist.MemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class MemeService {

    @Autowired
    private MemeRepository memeRepository;
    private final Pattern urlPattern = Pattern.compile("(http|https):\\/\\/(www)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)");

    public int saveMeme(Meme meme) {
        ensureURLMatchesPattern(meme);
        ensureMemeDoesNotAlreadyExist(meme);
        meme.setCreatedAt(System.currentTimeMillis());
        meme.setLastUpdatedAt(System.currentTimeMillis());
        memeRepository.save(meme);
        return meme.getId();
    }

    public List<Meme> getMemes(int page, int pageSize) {
        return memeRepository.getMemes(page, pageSize);
    }

    public Meme getMeme(int id) {
        Optional<Meme> meme = memeRepository.findById(id);
        if (meme.isEmpty()) throw new MemeNotFoundException();
        return meme.get();
    }

    public void deleteMeme(int id) {
        Meme meme = getMeme(id);
        memeRepository.delete(meme);
    }

    public void updateMeme(int id, Meme updatedMeme) {
        Meme oldMeme = getMeme(id);
        if (updatedMeme.getName() != null && !oldMeme.getName().equals(updatedMeme.getName())) {
            throw new MemeConstraintViolationException(List.of("Cannot update name of the author"));
        }

        oldMeme.setLastUpdatedAt(System.currentTimeMillis());
        if (updatedMeme.getCaption() != null) oldMeme.setCaption(updatedMeme.getCaption());
        if (updatedMeme.getUrl() != null) oldMeme.setUrl(updatedMeme.getUrl());
    }

    private void ensureMemeDoesNotAlreadyExist(Meme meme) {
        Meme previousMeme = memeRepository.findMeme(meme.getName(), meme.getCaption(), meme.getUrl());
        if (previousMeme != null) throw new MemeAlreadyExistsException();
    }

    private void ensureURLMatchesPattern(Meme meme) {
        Matcher m = urlPattern.matcher(meme.getUrl());
        if (!m.matches()) throw new MemeConstraintViolationException(List.of("Posted URL is not in valid format"));
    }
}
