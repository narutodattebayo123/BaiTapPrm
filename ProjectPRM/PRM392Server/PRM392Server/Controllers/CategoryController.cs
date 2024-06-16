using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using PRM392Server.Models;

namespace PRM392Server.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CategoryController : ControllerBase
    {
        OnlineStoreDBContext context = new OnlineStoreDBContext();

        [HttpGet]
        public IActionResult getAllCategory()
        {
            var categories = context.Categories.ToList();
            return Ok(categories);
        }

        [HttpGet("{id}")]
        public IActionResult getCategoryById(int id)
        {
            var categories = context.Categories.Where(x => x.CategoryId == id).ToList();
            if (categories.Count == 0)
            {
                return NotFound("khong co Category nao co id = " + id);
            }
            return Ok(categories);
        }

        [HttpPost]
        public IActionResult AddCategory(string userName, string password)
        {
            Category categories = new Category
            {
                CategoryName = userName,
            };
            context.Add(categories);
            context.SaveChanges();
            return Ok(categories);
        }

        [HttpPut]
        public IActionResult UpdateCategory(Category category)
        {
            Category categories = context.Categories.Find(category.CategoryId);
            if (categories == null)
            {
                return NotFound("khong co Category nao co id = " + category.CategoryId);
            }
            if (category.CategoryName == null)
            {
                categories.CategoryName = categories.CategoryName;
            }
            else
            {
                categories.CategoryName = category.CategoryName;
            }
            context.SaveChanges();
            return Ok(categories);
        }

        [HttpDelete]
        public IActionResult DeleteCategory(int id)
        {
            Category category = context.Categories.Find(id);
            if (category == null)
            {
                return NotFound("khong co Category nao co id = " + id);
            }
            context.Categories.Remove(category);
            context.SaveChanges();
            var categoryList = context.Categories.ToList();
            return Ok(categoryList);
        }
    }
}
