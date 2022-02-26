package com.encodesolution.product.api;

import com.encodesolution.product.model.Product;
import com.encodesolution.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({ProductController.class})
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void shouldGiveHttpResponseOK() throws Exception {
        Product product = TestUtils.getDummyProduct();
        Mockito.when(productService.save(any(Product.class))).thenReturn(TestUtils.getDummyProduct());
        RequestBuilder builder = MockMvcRequestBuilders
                .post(TestUtils.productServiceBaseURL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtils.getDummyProductInJson());
        mockMvc.perform(builder).andExpect(status().isOk());
    }
}