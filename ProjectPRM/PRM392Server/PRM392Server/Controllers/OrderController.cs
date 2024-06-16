using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using PRM392Server.Models;
using System.Security.Principal;

namespace PRM392Server.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class OrderController : ControllerBase
    {
        OnlineStoreDBContext context = new OnlineStoreDBContext();

        [HttpGet]
        public IActionResult getAllOrder()
        {
            var orders = context.Orders.ToList();
            return Ok(orders);
        }

        [HttpGet("{id}")]
        public IActionResult getOrderById(int id)
        {
            var orders = context.Orders.Where(x => x.OrderId == id).ToList();
            if (orders.Count == 0)
            {
                return NotFound("khong co order nao co id = " + id);
            }
            return Ok(orders);
        }

        [HttpPost]
        public IActionResult AddOrders(Order order)
        {
            Order orderAdd = new Order
            {
                AccountId = order.AccountId,
                OrderDate = order.OrderDate,
                TotalAmount = order.TotalAmount,
                VoucherId = order.VoucherId,
            };
            context.Add(orderAdd);
            context.SaveChanges();
            return Ok(orderAdd);
        }

        [HttpPut]
        public IActionResult UpdateOrder(Order order)
        {
            Order orderUpdate = context.Orders.Find(order.OrderId);
            if (orderUpdate == null)
            {
                return NotFound("khong co order nao co id = " + order.OrderId);
            }
            if (order.AccountId == null)
            {
                orderUpdate.AccountId = orderUpdate.AccountId;
            }
            else
            {
                orderUpdate.AccountId = order.AccountId;
            }
            if (order.OrderDate == null)
            {
                orderUpdate.OrderDate = orderUpdate.OrderDate;
            }
            else
            {
                orderUpdate.OrderDate = order.OrderDate;
            }
            if (order.TotalAmount == null)
            {
                orderUpdate.TotalAmount = orderUpdate.TotalAmount;
            }
            else
            {
                orderUpdate.TotalAmount = order.TotalAmount;
            }
            if (order.VoucherId == null)
            {
                orderUpdate.VoucherId = orderUpdate.VoucherId;
            }
            else
            {
                orderUpdate.VoucherId = order.VoucherId;
            }
            context.SaveChanges();
            return Ok(orderUpdate);
        }

        [HttpDelete]
        public IActionResult DeleteOrder(int id)
        {
            Order order = context.Orders.Find(id);
            if (order == null)
            {
                return NotFound("khong co order nao co id = " + id);
            }
            context.Orders.Remove(order);
            context.SaveChanges();
            var orderList = context.Orders.ToList();
            return Ok(orderList);
        }
    }
}
