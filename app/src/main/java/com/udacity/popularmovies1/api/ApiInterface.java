package com.udacity.popularmovies1.api;

import com.udacity.popularmovies1.models.PopularMoviesResponse;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by shareefoo
 */

public interface ApiInterface {

//    @GET("generate/code/{mobile}")
//    Call<VCodeResponse> getVerificationCode(@Path("mobile") String mobile);

    @GET("popular")
    Call<PopularMoviesResponse> getPopularMovies(@Query("api_key") String apiKey);

    @GET("top_rated")
    Call<PopularMoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);

//    @GET("cities")
//    Call<RegionResponse> getAllRegions(@Query("v_code") int vCode);
//
////    @FormUrlEncoded
////    @POST("client/create")
////    Call<UserResponse> createClient(@Query("v_code") String vCode,
////                                      @Field("name") String name,
////                                      @Field("email") String email,
////                                      @Field("area") String region,
////                                      @Field("pic") String pic,
////                                      @Field("system_type") String systemType,
////                                      @Field("token") String deviceToken);
//
//    @FormUrlEncoded
//    @POST("user/token")
//    Call<UserResponse> updateToken(@Query("v_code") int vCode,
//                                   @Field("token") String token);
//
////    @Multipart
////    @POST("client/create")
////    Call<UserResponse> createClient(@Query("v_code") int vCode,
////                                      @Part("name") RequestBody name,
////                                      @Part("email") RequestBody email,
////                                      @Part("area") RequestBody region,
////                                      @Part("system_type") RequestBody systemType,
////                                      @Part("token") RequestBody token,
////                                      @Part MultipartBody.Part file);
//
//    @Multipart
//    @POST("client/create")
//    Call<UserResponse> createClient(@Query("v_code") int vCode,
//                                    @PartMap Map<String, RequestBody> partMap,
//                                    @Part MultipartBody.Part profilePic);
//
////    @Multipart
////    @POST("client/create")
////    Call<UserResponse> createClient(@Query("v_code") int vCode,
////                                    @PartMap Map<String, RequestBody> partMap);
//
//    //    @FormUrlEncoded
////    @POST("delegate/create")
////    Call<UserResponse> createProvider(@Query("v_code") int vCode,
////                                        @Field("name") String name,
////                                        @Field("phone") String phone,
////                                        @Field("email") String email,
////                                        @Field("area") String area,
////                                        @Field("identity_number") String identityNumber,
////                                        @Field("identity_pic") String identityPic,
////                                        @Field("car_licence_pic") String carLicencePic,
////                                        @Field("pic") String pic);
//
//    @Multipart
//    @POST("delegate/create")
//    Call<UserResponse> createProvider(@Query("v_code") int vCode,
//                                      @PartMap Map<String, RequestBody> partMap,
//                                      @Part MultipartBody.Part identityPic,
//                                      @Part MultipartBody.Part carLicencePic,
//                                      @Part MultipartBody.Part profilePic);
//
//    @POST("client/update")
//    Call<UserResponse> updateClient(@Query("v_code") int vCode,
//                                    @PartMap Map<String, RequestBody> partMap,
//                                    @Part MultipartBody.Part profilePic);
//
//    @POST("delegate/update")
//    Call<UserResponse> updateProvider(@Query("v_code") int vCode,
//                                      @PartMap Map<String, RequestBody> partMap,
//                                      @Part MultipartBody.Part profilePic);
//
//    @GET("service")
//    Call<ServiceResponse> getServices(@Query("v_code") int vCode);
//
//    @FormUrlEncoded
//    @POST("request/create")
//    Call<OrderRequestResponse> sendOrder(@Query("v_code") int vCode,
//                                         @Field("longitude") String longitude,
//                                         @Field("latitude") String latitude,
//                                         @Field("duration") int duration,
//                                         @Field("service_type") String type,
//                                         @Field("service_id") String serviceId,
//                                         @Field("description") String description);
//
//    @GET("request/show")
//    Call<RequestDataResponse> getClientRequests(@Query("v_code") int vCode);
//
//    @GET("delegate/requests/works")
//    Call<RequestDataResponse> getProviderWork(@Query("v_code") int vCode);
//
//    @FormUrlEncoded
//    @POST("evaluate")
//    Call<RatingDataResponse> rateProvider(@Query("v_code") int vCode,
//                                          @Field("to") String providerId,
//                                          @Field("evaluation") String rate,
//                                          @Field("note") String note,
//                                          @Field("request_id") String requestId);
//
//    @GET("client/evaluations")
//    Call<RatingDataResponse> getClientRatings(@Query("v_code") int vCode);
//
//
//    @GET("client/show")
//    Call<UserInfoResponse> getClientInfo(@Query("v_code") int vCode);
//
//    @GET("delegate")
//    Call<UserInfoResponse> getProviderInfo(@Query("v_code") int vCode);
//
//    @FormUrlEncoded
//    @POST("delegate/send/offer")
//    Call<OfferResponse> sendOffer(@Query("v_code") int vCode,
//                                  @Field("price") String price,
//                                  @Field("note") String note,
//                                  @Field("request_id") int requestId);
//
//    @GET("accept/offer/{offer_id}/{status}")
//    Call<SimpleResponse> respondOffer(@Path("offer_id") int offerId,
//                                      @Path("status") int status,
//                                      @Query("v_code") int vCode);
//
//    @GET("request/change/{request_id}/{status}")
//    Call<SimpleResponse> changeRequestStatus(@Path("request_id") int requestId,
//                                             @Path("status") int status,
//                                             @Query("v_code") int vCode);
//
//    @FormUrlEncoded
//    @POST("message/send")
//    Call<MessageDataResponse> sendMessage(@Query("v_code") int vCode,
//                                          @Field("to") int to,
//                                          @Field("request_id") int requestId,
//                                          @Field("message") String message,
//                                          @Field("type") String type);
//
//    @GET("conversation/{request_id}")
//    Call<ConversationDataResponse> getConversation(@Path("request_id") int requestId,
//                                                   @Query("v_code") int vCode);
//
//    @FormUrlEncoded
//    @POST("contact/create")
//    Call<ContactResponse> contact(@Query("v_code") int vCode,
//                                  @Field("name") String name,
//                                  @Field("phone") String phone,
//                                  @Field("note") String note,
//                                  @Field("type") String type);
//
//    @Multipart
//    @POST("delegate/financial/transaction")
//    Call<SimpleResponse> chargeAccount(@Query("v_code") int vCode,
//                                       @PartMap Map<String, RequestBody> partMap,
//                                       @Part MultipartBody.Part paymentPic);

}