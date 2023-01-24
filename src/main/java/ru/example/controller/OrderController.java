package ru.example.controller;

import org.springframework.web.bind.annotation.*;
import ru.example.dto.OrderDto;
import ru.example.dto.OrganizationDto;
import ru.example.model.Order;
import ru.example.model.Organization;
import ru.example.repository.OrderRepository;
import ru.example.repository.OrganizationRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrganizationRepository organizationRepository;

    public OrderController(OrderRepository orderRepository, OrganizationRepository organizationRepository) {
        this.orderRepository = orderRepository;
        this.organizationRepository = organizationRepository;
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("{id}")
    public OrderDto getOrder(@PathVariable Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException());
        OrderDto orderDto = new OrderDto();
        orderDto.setTitle(order.getTitle());
        orderDto.setCreateDate(order.getCreateDate());
        if (order.getDeclineDate() != null) {
            orderDto.setDeclineDate(order.getDeclineDate());
        }
        if (order.getOrganization() != null) {
            Organization organization = order.getOrganization();
            OrganizationDto organizationDto = new OrganizationDto();
            organizationDto.setName(organization.getName());
            organizationDto.setAddress(organization.getAddress());
            orderDto.setOrganizationDto(organizationDto);
        }
        return orderDto;
    }

    @PostMapping
    public void createOrder(@RequestBody OrderDto orderDto) {
        OrganizationDto organizationDto = orderDto.getOrganizationDto();
        Organization organization = new Organization();
        organization.setName(organizationDto.getName());
        organization.setAddress(organizationDto.getAddress());

        Order order = new Order();
        order.setTitle(orderDto.getTitle());
        LocalDateTime createDate = LocalDateTime.now();
        order.setCreateDate(createDate);
        order.setOrganization(organization);
        orderRepository.save(order);
    }

    @DeleteMapping("{id}")
    public void deleteOrder(@PathVariable Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException());
        LocalDateTime declineDate = LocalDateTime.now();
        order.setDeclineDate(declineDate);
        orderRepository.save(order);
    }
}
