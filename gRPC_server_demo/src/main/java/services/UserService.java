package services;

import com.demo.grpc.User;
import com.demo.grpc.userGrpc;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

public class UserService extends userGrpc.userImplBase {
    private static final Logger logger = Logger.getLogger(UserService.class.getName());
    @Override
    public void login(User.LoginReq request, StreamObserver<User.APIRes> responseObserver) {

        String userName = request.getUsername();
        String password = request.getPassword();

        logger.info("Request generated from user : " + userName);

        User.APIRes.Builder response = User.APIRes.newBuilder();
        if (userName.equals("raihan123") && password.equals("abc123")){
            response.setResCode(200).setMessage("SUCCESS");
            logger.info("Login successful for user : " + userName);
        }
        else {
            response.setResCode(400).setMessage("BAD REQUEST");
            logger.info("Login failed for user : " + userName);
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIRes> responseObserver) {
        super.logout(request, responseObserver);
    }
}
