package io.github.djunicode.canteenapp.RetrofitInterfaces;

import java.util.List;

import io.github.djunicode.canteenapp.RequestObjects.ChangePassword;
import io.github.djunicode.canteenapp.RequestObjects.SendOrder;
import io.github.djunicode.canteenapp.RequestObjects.SignInRequest;
import io.github.djunicode.canteenapp.RequestObjects.SignUpRequest;
import io.github.djunicode.canteenapp.ResponseObjects.OrderSentResponse;
import io.github.djunicode.canteenapp.ResponseObjects.ProfileResponse;
import io.github.djunicode.canteenapp.ResponseObjects.SignInResponse;
import io.github.djunicode.canteenapp.ResponseObjects.SignUpResponse;
import io.github.djunicode.canteenapp.models.MenuItem;
import io.github.djunicode.canteenapp.models.Order;
import io.github.djunicode.canteenapp.models.User;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("auth/token/login/")
    Call<SignInResponse> createPostLogin(@Body SignInRequest signInRequest);


    @GET("menu/")
    Call<List<MenuItem>> getMenu();


    @POST("auth/users/set_password/")
    Call<ResponseBody> changePassword(@Body ChangePassword changePassword);

    @POST("student_signup/")
    Call<SignUpResponse>createPostSignUp(@Body SignUpRequest signUpRequest);

    @POST("orders/")
    Call<OrderSentResponse> placeOrder(@Header ("Authorization")String token,
                                       @Body SendOrder sendOrder);

    @GET("auth/users/me")
    Call<User> fetchUser(@Header ("Authorization")String token);

    @GET("user-orders/previous_orders")
    Call<List<Order>> getPreviousOrders(@Header ("Authorization")String token);



    @GET("user-orders/current_orders")
    Call<List<Order>> getCurrentOrders(@Header ("Authorization")String token);

    @GET("student-user/profile/")
    Call<ProfileResponse> getProfile(@Header ("Authorization")String token);

}
