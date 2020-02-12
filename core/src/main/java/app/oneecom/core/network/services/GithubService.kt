/*
 * Copyright 2019 vmadalin.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app.oneecom.core.network.services

import app.oneecom.core.network.responses.BaseResponse
import app.oneecom.core.network.responses.Category
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Representation interface of the Marvel API endpoints.
 */
interface GithubService {

    /**
     * Fetches lists of categories with optional filters.
     *
     * @param apiKey A unique identifier used to authenticate all calling to an API.
     * @param hash A md5 digest of the ts parameter, private API key and public.
     * @param timestamp A digital current record of the time.
     * @param offset Skip the specified number of resources in the result set.
     * @param limit Limit the result set to the specified number of resources.
     * @return Response for categories resource.
     */
    @Headers("Cache-Control: no-cache")
    @GET("master/v1/categories.json")
    suspend fun getCategories(
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("ts") timestamp: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): BaseResponse<Category>

    /**
     * Fetches a single character resource. It is the canonical URI for any character resource
     * provided by the API.
     *
     * @return Response for single character resource.
     */
//    @GET("/v1/public/characters/{id}")
//    suspend fun getCharacter(
//        @Path("id") id: Long,
//        @Query("apikey") apiKey: String,
//        @Query("hash") hash: String,
//        @Query("ts") timestamp: String
//    ): BaseResponse<CharacterResponse>

}
