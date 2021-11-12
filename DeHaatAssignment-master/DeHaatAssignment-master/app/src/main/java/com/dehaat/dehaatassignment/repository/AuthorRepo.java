package com.dehaat.dehaatassignment.repository;

import com.dehaat.dehaatassignment.dao.AuthorDao;
import com.dehaat.dehaatassignment.rest.AppRestClientService;

/**
 * Created by Pallaw Pathak on 16/06/20. - https://www.linkedin.com/in/pallaw-pathak-a6a324a1/
 */
public class AuthorRepo {

    private AuthorDao authorDao;
    private AppRestClientService apiService;

    public AuthorRepo(AuthorDao authorDao, AppRestClientService apiService) {
        this.authorDao = authorDao;
        this.apiService = apiService;
    }
}
