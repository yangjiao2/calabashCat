/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.calabashCat.android.sample.data.datasource;

import com.yelp.clientlib.entities.Business;
import com.yelp.clientlib.entities.SearchResponse;

import rx.Observable;

/**
 * Interface that represents a data store from where data is retrieved.
 */
public interface UserDataStore {
  /**
   * Get an {@link rx.Observable} which will emit a List of {@link SearchResponse}.
   */
  Observable<SearchResponse> getSearchResponse();

  /**
   * Get an {@link rx.Observable} which will emit a {@link Business} by its id.
   *
   * @param userId The id to retrieve user data.
   */
  Observable<Business> getBusiness(final int userId);
}
