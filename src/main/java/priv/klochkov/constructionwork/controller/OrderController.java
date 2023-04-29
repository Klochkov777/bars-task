package priv.klochkov.constructionwork.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.klochkov.constructionwork.dto.constructionorderdto.OrderDto;
import priv.klochkov.constructionwork.dto.orderdtoforlist.OrderDtoList;
import priv.klochkov.constructionwork.sevice.impl.OrderServiceImpl;

import java.util.List;
//import priv.klochkov.constructionwork.sevice.utils.OrderMapper;

@Controller
@ResponseBody
@RequestMapping("/order")
public class OrderController {
    private final OrderServiceImpl orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/hello")
    public void hello() {
        System.out.println("HERE!!!!!!!!!!");
    }

    @GetMapping("/{id}")
    @ResponseBody
    public OrderDto getOrder(@PathVariable("id") long id) {
        System.out.println("HERE!!!!!!!!!!");
        return orderService.getOrderDtoByOrderId(id);
    }



    @GetMapping("/orders")
    @ResponseBody
    public List<OrderDtoList> getOrders() {
        return orderService.getAllOrders();
    }













//    private final PersonService personService;
//
//    public PersonController(PersonService personService) {
//        this.personService = personService;
//    }
//
//    @GetMapping("/{id}")
//    public PersonDto getPerson(@PathVariable("id") long id) {
//        Person person = personService.getPersonById(id);
//        return PersonMapper.toDto(person);
//    }
//
//    @PostMapping("/")
//    public PersonDto createPerson(@RequestBody PersonDto personDto) {
//        Person person = PersonMapper.toEntity(personDto);
//        person = personService.createPerson(person);
//        return PersonMapper.toDto(person);
//    }





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
