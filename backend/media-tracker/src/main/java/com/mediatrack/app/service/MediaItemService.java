package com.mediatrack.app.service;

import com.mediatrack.app.model.MediaItem;

import java.util.List;

public interface MediaItemService {
    MediaItem saveMediaItem(MediaItem mediaItem);
    List<MediaItem> getMediaByUserId(Long userId);
    MediaItem updateMediaItem(MediaItem mediaItem);
    List<MediaItem> getAllMediaItems();
    MediaItem getMediaItemById(Long id);

}
