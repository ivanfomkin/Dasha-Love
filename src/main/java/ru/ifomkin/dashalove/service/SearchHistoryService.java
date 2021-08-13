package ru.ifomkin.dashalove.service;

import org.springframework.stereotype.Service;
import ru.ifomkin.dashalove.entity.SearchHistory;
import ru.ifomkin.dashalove.repository.SearchHistoryRepository;

@Service
public class SearchHistoryService {
    private final SearchHistoryRepository repository;

    public SearchHistoryService(SearchHistoryRepository repository) {
        this.repository = repository;
    }

    public void save(String name) {
        repository.save(new SearchHistory(name));
    }
}
