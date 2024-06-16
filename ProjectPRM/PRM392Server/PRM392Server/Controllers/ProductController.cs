using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using PRM392Server.Models;

namespace PRM392Server.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ProductController : ControllerBase
    {
        OnlineStoreDBContext context = new OnlineStoreDBContext();

        [HttpGet]
        public IActionResult getAllProduct()
        {
            var products = context.Products.ToList();
            return Ok(products);
        }

        [HttpGet("{id}")]
        public IActionResult getProductById(int id)
        {
            var products = context.Products.Where(x => x.ProductId == id).ToList();
            if (products.Count == 0)
            {
                return NotFound("khong co product nao co id = " + id);
            }
            return Ok(products);
        }

        [HttpPost]
        public IActionResult AddProduct(Product product)
        {
            Product productAdd = new Product
            {
                ProductName = product.ProductName,
                BrandId = product.BrandId,
                Price = product.Price,
                Stock = product.Stock,
                Description = product.Description,
                CategoryId = product.CategoryId,
            };
            context.Add(productAdd);
            context.SaveChanges();
            return Ok(productAdd);
        }

        [HttpPut]
        public IActionResult UpdateProduct(Product product)
        {
            Product producttUpdate = context.Products.Find(product.ProductId);
            if (producttUpdate == null)
            {
                return NotFound("khong co account nao co id = " + product.ProductId);
            }
            if (product.ProductName == null)
            {
                producttUpdate.ProductName = producttUpdate.ProductName;
            }
            else
            {
                producttUpdate.ProductName = product.ProductName;
            }
            if (product.BrandId == null)
            {
                producttUpdate.BrandId = producttUpdate.BrandId;
            }
            else
            {
                producttUpdate.BrandId = product.BrandId;
            }
            if (product.Price == null)
            {
                producttUpdate.Price = producttUpdate.Price;
            }
            else
            {
                producttUpdate.Price = product.Price;
            }
            if (product.Stock == null)
            {
                producttUpdate.Stock = producttUpdate.Stock;
            }
            else
            {
                producttUpdate.Stock = product.Stock;
            }
            if (product.Description == null)
            {
                producttUpdate.Description = producttUpdate.Description;
            }
            else
            {
                producttUpdate.Description = product.Description;
            }
            if (product.CategoryId == null)
            {
                producttUpdate.CategoryId = producttUpdate.CategoryId;
            }
            else
            {
                producttUpdate.CategoryId = product.CategoryId;
            }
            context.SaveChanges();
            return Ok(producttUpdate);
        }

        [HttpDelete]
        public IActionResult DeleteProduct(int id)
        {
            Product product = context.Products.Find(id);
            if (product == null)
            {
                return NotFound("khong co product nao co id = " + id);
            }
            context.Products.Remove(product);
            context.SaveChanges();
            var productList = context.Products.ToList();
            return Ok(productList);
        }
    }
}
