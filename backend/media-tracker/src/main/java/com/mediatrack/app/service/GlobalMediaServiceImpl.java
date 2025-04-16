package com.mediatrack.app.service;

import com.mediatrack.app.model.GlobalMedia;
import com.mediatrack.app.repository.GlobalMediaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlobalMediaServiceImpl implements GlobalMediaService {

    private final GlobalMediaRepository repository;

    public GlobalMediaServiceImpl(GlobalMediaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GlobalMedia> getAllCatalogMedia() {
        return repository.findAll();
    }

    @Override
    public GlobalMedia addGlobalMedia(GlobalMedia media) {
        return repository.save(media);
    }
}
