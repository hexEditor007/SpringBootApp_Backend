package dev.saransh.springbootapp_backend.dtos;

import dev.saransh.springbootapp_backend.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class WrapperForFakeStoreProductService {

    private List<FakeStoreProductDto> data;

    public List<Product> toProductList() {
        List<Product> list = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : data) {
            list.add(fakeStoreProductDto.toProduct());
        }
        return list;
    }
}
