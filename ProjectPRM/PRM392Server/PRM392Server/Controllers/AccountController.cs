using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using PRM392Server.Models;

namespace PRM392Server.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class AccountController : ControllerBase
    {
        OnlineStoreDBContext context = new OnlineStoreDBContext();

        [HttpGet]
        public IActionResult getAllAccount()
        {
            var accounts = context.Accounts.ToList();
            return Ok(accounts);
        }

        [HttpGet("{id}")]
        public IActionResult getAccountById(int id)
        {
            var accounts = context.Accounts.Where(x => x.AccountId == id).ToList();
            if (accounts.Count == 0)
            {
                return NotFound("khong co account nao co id = " + id);
            }
            return Ok(accounts);
        }

        [HttpPost]
        public IActionResult AddAccount(string userName, string password)
        {
            Account accountAdd = new Account
            {
                Username = userName,
                Password = password,
                RoleId = 1,
            };
            context.Add(accountAdd);
            context.SaveChanges();
            return Ok(accountAdd);
        }

        [HttpPut]
        public IActionResult UpdateAccount(Account account)
        {
            Account accountUpdate = context.Accounts.Find(account.AccountId);
            if (accountUpdate == null)
            {
                return NotFound("khong co account nao co id = " + account.AccountId);
            }
            if (account.Username == null)
            {
                accountUpdate.Username = accountUpdate.Username;
            }
            else
            {
                accountUpdate.Username = account.Username;
            }
            if(account.Password == null)
            {
                accountUpdate.Password = accountUpdate.Password;
            }
            else
            {
                accountUpdate.Password = account.Password;
            }
            if (account.RoleId == null)
            {
                accountUpdate.RoleId = accountUpdate.RoleId;
            }
            else
            {
                accountUpdate.RoleId = account.RoleId;
            }
            context.SaveChanges();
            return Ok(accountUpdate);
        }

        [HttpDelete]
        public IActionResult DeleteAccount(int id)
        {
            Account account = context.Accounts.Find(id);
            if (account == null)
            {
                return NotFound("khong co account nao co id = " + id);
            }
            context.Accounts.Remove(account);
            context.SaveChanges();
            var accountList = context.Accounts.ToList();
            return Ok(accountList);
        }
    }
}
