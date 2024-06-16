using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using PRM392Server.Models;

namespace PRM392Server.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class BrandController : ControllerBase
    {
        OnlineStoreDBContext context = new OnlineStoreDBContext();
        [HttpGet]
        public IActionResult getAllBrand()
        {
            var accounts = context.Brands.ToList();
            return Ok(accounts);
        }

        [HttpGet("{id}")]
        public IActionResult getBrandById(int id)
        {
            var Brands = context.Brands.Where(x => x.BrandId == id).ToList();
            if (Brands.Count == 0)
            {
                return NotFound("khong co brand nao co id = " + id);
            }
            return Ok(Brands);
        }

        [HttpPost("{brandName}")]
        public IActionResult AddBrand(string brandName)
        {
            Brand BrandsAdd = new Brand
            {
                BrandName = brandName,
            };
            context.Add(BrandsAdd);
            context.SaveChanges();
            return Ok(BrandsAdd);
        }

        [HttpPut]
        public IActionResult UpdateBrand(Brand brand)
        {
            Brand brandUpdate = context.Brands.Find(brand.BrandId);
            if (brandUpdate == null)
            {
                return NotFound("khong co brand nao co id = " + brand.BrandId);
            }
            if (brand.BrandName == null)
            {
                brandUpdate.BrandName = brandUpdate.BrandName;
            }
            else
            {
                brandUpdate.BrandName = brand.BrandName;
            }
            context.SaveChanges();
            return Ok(brandUpdate);
        }

        [HttpDelete]
        public IActionResult DeleteBrand(int id)
        {
            Brand brand = context.Brands.Find(id);
            if (brand == null)
            {
                return NotFound("khong co brand nao co id = " + id);
            }
            context.Brands.Remove(brand);
            context.SaveChanges();
            var brandtList = context.Brands.ToList();
            return Ok(brandtList);
        }
    }
}
