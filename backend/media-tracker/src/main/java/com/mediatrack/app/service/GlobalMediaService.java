package com.mediatrack.app.service;

import com.mediatrack.app.model.GlobalMedia;
import java.util.List;

public interface GlobalMediaService {
    List<GlobalMedia> getAllCatalogMedia();
    GlobalMedia addGlobalMedia(GlobalMedia media);
}
