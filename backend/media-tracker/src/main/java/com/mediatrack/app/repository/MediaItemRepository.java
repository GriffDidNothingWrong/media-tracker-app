package com.mediatrack.app.repository;

import com.mediatrack.app.model.MediaItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MediaItemRepository extends JpaRepository<MediaItem, Long> {
    List<MediaItem> findByUserId(Long userId);
}
