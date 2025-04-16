package com.mediatrack.app.service;

import com.mediatrack.app.model.MediaItem;
import com.mediatrack.app.repository.MediaItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaItemServiceImpl implements MediaItemService {

    private MediaItemRepository mediaItemRepository;

    public MediaItemServiceImpl(MediaItemRepository mediaItemRepository) {
        this.mediaItemRepository = mediaItemRepository;
    }

    @Override
    public MediaItem saveMediaItem(MediaItem mediaItem) {
        return mediaItemRepository.save(mediaItem);
    }

    @Override
    public List<MediaItem> getMediaByUserId(Long userId) {
        return mediaItemRepository.findByUserId(userId);
    }

    @Override
    public MediaItem updateMediaItem(MediaItem mediaItem) {
        return mediaItemRepository.save(mediaItem); // same save() method
    }

    @Override
    public List<MediaItem> getAllMediaItems() {
        return mediaItemRepository.findAll();
    }

    @Override
    public MediaItem getMediaItemById(Long id) {
        return mediaItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Media item not found with id: " + id));
    }

}
