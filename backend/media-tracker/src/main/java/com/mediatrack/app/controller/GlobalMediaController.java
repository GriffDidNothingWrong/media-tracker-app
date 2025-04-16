package com.mediatrack.app.controller;

import com.mediatrack.app.model.GlobalMedia;
import com.mediatrack.app.service.GlobalMediaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class GlobalMediaController {

    private final GlobalMediaService globalMediaService;

    public GlobalMediaController(GlobalMediaService globalMediaService) {
        this.globalMediaService = globalMediaService;
    }

    @GetMapping("/all")
    public List<GlobalMedia> getAllCatalog() {
        return globalMediaService.getAllCatalogMedia();
    }

    @PostMapping("/add")
    public GlobalMedia addCatalogEntry(@RequestBody GlobalMedia media) {
        return globalMediaService.addGlobalMedia(media);
    }
}
