package com.example.category.applications.grpcserver;

import com.example.category.repositories.CategoryRepository;
import com.example.grpc.ExistCategoryRequest;
import com.example.grpc.ExistCategoryResponse;
import com.example.grpc.ExistCategoryServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ExistCategoryService extends ExistCategoryServiceGrpc.ExistCategoryServiceImplBase {

    private final CategoryRepository categoryRepository;

    public ExistCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void existCategory(ExistCategoryRequest request, StreamObserver<ExistCategoryResponse> responseObserver) {
        Long categoryId = request.getCategoryId();

        boolean res = categoryRepository.existsById(categoryId);

        ExistCategoryResponse reply = ExistCategoryResponse.newBuilder()
                .setResult(res)
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
