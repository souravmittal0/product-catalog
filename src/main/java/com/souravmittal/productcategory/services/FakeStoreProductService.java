package com.souravmittal.productcategory.services;

import com.souravmittal.productcategory.constants.Constant;
import com.souravmittal.productcategory.dtos.FakeStoreProductDto;
import com.souravmittal.productcategory.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.*;

import java.util.Arrays;
import java.util.List;

@Primary
@Service
@RequiredArgsConstructor
public class FakeStoreProductService implements ProductService {

    private final RestTemplate restTemplate;

    @Override
    public List<Product> getProducts() {
        ResponseEntity<FakeStoreProductDto[]> fakeStoreProductDtoResponseEntity = requestForEntity(
                Constant.FAKE_STORE_URL, HttpMethod.GET, null, FakeStoreProductDto[].class);
        return Arrays.stream(fakeStoreProductDtoResponseEntity.getBody())
                .map(Product::from).toList();
    }

    @Override
    public Product getProductById(long id) {
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = requestForEntity(
                Constant.FAKE_STORE_URL + "{id}", HttpMethod.GET, null, FakeStoreProductDto.class, id);
        if (fakeStoreProductDtoResponseEntity.getStatusCode().is2xxSuccessful() &&
                fakeStoreProductDtoResponseEntity.getBody() != null) {
            //Product product = new Product();
            //BeanUtils.copyProperties(fakeStoreProductDtoResponseEntity.getBody(), product);
            return Product.from(fakeStoreProductDtoResponseEntity.getBody());
        }
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = requestForEntity(
                Constant.FAKE_STORE_URL, HttpMethod.POST, FakeStoreProductDto.from(product), FakeStoreProductDto.class);
        return Product.from(fakeStoreProductDtoResponseEntity.getBody());
    }

    @Override
    public Product replaceProduct(long id, Product product) {
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = requestForEntity(
                Constant.FAKE_STORE_URL + "{id}", HttpMethod.PUT, FakeStoreProductDto.from(product), FakeStoreProductDto.class, id);
        return Product.from(fakeStoreProductDtoResponseEntity.getBody());
    }

    @Override
    public Product updateProduct(long id, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(long id) {
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = requestForEntity(
                Constant.FAKE_STORE_URL + "{id}", HttpMethod.DELETE, null, FakeStoreProductDto.class, id);
        return Product.from(fakeStoreProductDtoResponseEntity.getBody());
    }


    private <T> ResponseEntity<T> requestForEntity(String url,
                                                   HttpMethod httpMethod,
                                                   Object request, Class<T> responseType,
                                                   Object... uriVariables) throws RestClientException {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }
}
