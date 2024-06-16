using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using PRM392Server.Models;

namespace PRM392Server.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class RoleController : ControllerBase
    {
        OnlineStoreDBContext context = new OnlineStoreDBContext();

        [HttpGet]
        public IActionResult getAllRole()
        {
            var roles = context.Roles.ToList();
            return Ok(roles);
        }

        [HttpGet("{id}")]
        public IActionResult getRoleById(int id)
        {
            var roles = context.Roles.Where(x => x.RoleId == id).ToList();
            if (roles.Count == 0)
            {
                return NotFound("khong co role nao co id = " + id);
            }
            return Ok(roles);
        }

        [HttpPost]
        public IActionResult AddRole(string roleName)
        {
            Role role = new Role
            {
                RoleName = roleName,
            };
            context.Add(role);
            context.SaveChanges();
            return Ok(role);
        }

        [HttpPut]
        public IActionResult UpdateRole(Role role)
        {
            Role roleUpdate = context.Roles.Find(role.RoleId);
            if (roleUpdate == null)
            {
                return NotFound("khong co account nao co id = " + role.RoleId);
            }
            if (roleUpdate.RoleName == null)
            {
                roleUpdate.RoleName = roleUpdate.RoleName;
            }
            else
            {
                roleUpdate.RoleName = role.RoleName;
            }
            context.SaveChanges();
            return Ok(roleUpdate);
        }

        [HttpDelete]
        public IActionResult DeleteRole(int id)
        {
            Role role = context.Roles.Find(id);
            if (role == null)
            {
                return NotFound("khong co role nao co id = " + id);
            }
            context.Roles.Remove(role);
            context.SaveChanges();
            var roleList = context.Roles.ToList();
            return Ok(roleList);
        }
    }
}
