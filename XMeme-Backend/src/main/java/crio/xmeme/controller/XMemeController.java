package crio.xmeme.controller;

import crio.xmeme.model.Meme;
import crio.xmeme.service.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequestMapping(value = "", produces = "application/json")
public class XMemeController {

    @Autowired
    MemeService memeService;

    @PostMapping("/memes")
    public String submitMeme(@RequestBody @Valid Meme meme) {
        return String.format("{\"id\" : %d}", memeService.saveMeme(meme));
    }

    @GetMapping("/memes")
    public List<Meme> getMemes(
            @RequestParam(required = false, defaultValue = "0") @Min(0) int page,
            @RequestParam(required = false, defaultValue = "100") @Min(1) int pageSize) {
        return memeService.getMemes(page, pageSize);
    }

    @GetMapping("/memes/{id}")
    public Meme getMeme(@PathVariable @Min(1) int id) {
        return memeService.getMeme(id);
    }

    @PatchMapping("/memes/{id}")
    public void updateMeme(@PathVariable @Min(1) int id, @RequestBody Meme updatedMeme) {
        memeService.updateMeme(id, updatedMeme);
    }

    @DeleteMapping("/memes/{id}")
    public void deleteMeme(@PathVariable @Min(1) int id) {
        memeService.deleteMeme(id);
    }
}
