package priv.klochkov.constructionwork.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.klochkov.constructionwork.dto.OrderDto;
import priv.klochkov.constructionwork.entity.OrderEntity;
import priv.klochkov.constructionwork.sevice.OrderService;
import priv.klochkov.constructionwork.sevice.impl.OrderServiceImpl;
import priv.klochkov.constructionwork.sevice.utils.OrderMapper;

@Controller
@RequestMapping("/orders")
public class OrderController {



    private OrderServiceImpl orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

//    @GetMapping
//    @ResponseBody
//    public String getHello() {
//        return "hello";
//    }

    @GetMapping("/{id}")
    public OrderDto getPerson(@PathVariable("id") long id) {
        System.out.println("HELLO!!!!");
        OrderEntity order = orderService.getOrderById(id);
        return OrderMapper.INSTANCE.orderEntityToOrderDto(order);
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
