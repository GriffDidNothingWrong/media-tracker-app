package com.mediatrack.app.controller;

import com.mediatrack.app.model.MediaItem;
import com.mediatrack.app.service.MediaItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media")
public class MediaController {

    private final MediaItemService mediaItemService;

    public MediaController(MediaItemService mediaItemService) {
        this.mediaItemService = mediaItemService;
    }

    @PostMapping("/add")
    public MediaItem addMediaItem(@RequestBody MediaItem mediaItem) {
        return mediaItemService.saveMediaItem(mediaItem);
    }

    @GetMapping("/user/{userId}")
    public List<MediaItem> getMediaByUser(@PathVariable Long userId) {
        return mediaItemService.getMediaByUserId(userId);
    }

    @GetMapping("/{id}")
    public MediaItem getMediaItemById(@PathVariable Long id) {
        return mediaItemService.getMediaItemById(id);
    }

    @GetMapping("/all")
    public List<MediaItem> getAllMediaItems() {
        return mediaItemService.getAllMediaItems();
    }

    @PutMapping("/update")
    public MediaItem updateMediaItem(@RequestBody MediaItem mediaItem) {
        return mediaItemService.updateMediaItem(mediaItem);
    }
}

