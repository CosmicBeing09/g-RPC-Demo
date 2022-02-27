import com.demo.grpc.User;
import com.demo.grpc.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.logging.Logger;

public class GrpcClient {

    private static final Logger logger = Logger.getLogger(GrpcClient.class.getName());

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);
        User.LoginReq request = User.LoginReq.newBuilder()
                .setUsername("raihan123")
                .setPassword("abc123")
                .build();
        User.APIRes apiRes = userStub.login(request);
        logger.info(apiRes.getResCode() + "\n" + apiRes.getMessage());

    }
}
