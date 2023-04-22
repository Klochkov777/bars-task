package priv.klochkov.constructionwork.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import priv.klochkov.constructionwork.sevice.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {


    @Autowired
    private OrderService orderService;














//    @GetMapping
//    public String getAllProducts(Model model) {
//        List<Product> products = productService.getAllProducts();
//        model.addAttribute("products", products);
//        return "products";
//    }
//
//    @GetMapping("/{productId}")
//    public String getProductById(@PathVariable Long productId, Model model) {
//        Product product = productService.getProductById(productId);
//        model.addAttribute("product", product);
//        return "product";
//    }
//
//    @GetMapping("/add")
//    public String showAddProductForm(Model model) {
//        model.addAttribute("product", new Product());
//        return "add-product";
//    }
//
//    @PostMapping("/add")
//    public String addProduct(@ModelAttribute("product") Product product) {
//        productService.addProduct(product);
//        return "redirect:/products";
//    }
//
//    @GetMapping("/{productId}/edit")
//    public String showEditProductForm(@PathVariable Long productId, Model model) {
//        Product product = productService.getProductById(productId);
//        model.addAttribute("product", product);
//        return "edit-product";
//    }
//
//    @PostMapping("/{productId}/edit")
//    public String editProduct(@PathVariable Long productId, @ModelAttribute("product") Product product) {
//        product.setId(productId);
//        productService.editProduct(product);
//        return "redirect:/products";
//    }
//
//    @GetMapping("/{productId}/delete")
//    public String deleteProduct(@PathVariable Long productId) {
//        productService.deleteProduct(productId);
//        return "redirect:/products";
//    }


}
