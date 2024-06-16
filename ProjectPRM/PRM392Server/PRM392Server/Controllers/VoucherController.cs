using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using PRM392Server.Models;

namespace PRM392Server.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class VoucherController : ControllerBase
    {
        OnlineStoreDBContext context = new OnlineStoreDBContext();

        [HttpGet]
        public IActionResult getAllVoucher()
        {
            var vouchers = context.Vouchers.ToList();
            return Ok(vouchers);
        }

        [HttpGet("{id}")]
        public IActionResult getVoucherById(int id)
        {
            var vouchers = context.Vouchers.Where(x => x.VoucherId == id).ToList();
            if (vouchers.Count == 0)
            {
                return NotFound("khong co voucher nao co id = " + id);
            }
            return Ok(vouchers);
        }

        [HttpPost]
        public IActionResult AddVoucher(Voucher voucher)
        {
            Voucher voucherAdd = new Voucher
            {
                VoucherCode = voucher.VoucherCode,
                Discount = voucher.Discount,
                ExpiryDate = voucher.ExpiryDate,
            };
            context.Add(voucherAdd);
            context.SaveChanges();
            return Ok(voucherAdd);
        }

        [HttpPut]
        public IActionResult UpdateVoucher(Voucher voucher)
        {
            Voucher voucherUpdate = context.Vouchers.Find(voucher.VoucherId);
            if (voucherUpdate == null)
            {
                return NotFound("khong co voucher nao co id = " + voucher.VoucherId);
            }
            if (voucher.VoucherCode == null)
            {
                voucherUpdate.VoucherCode = voucherUpdate.VoucherCode;
            }
            else
            {
                voucherUpdate.VoucherCode = voucher.VoucherCode;
            }
            if (voucher.Discount == null)
            {
                voucherUpdate.Discount = voucherUpdate.Discount;
            }
            else
            {
                voucherUpdate.Discount = voucher.Discount;
            }
            if (voucher.ExpiryDate == null)
            {
                voucherUpdate.ExpiryDate = voucherUpdate.ExpiryDate;
            }
            else
            {
                voucherUpdate.ExpiryDate = voucher.ExpiryDate;
            }
            context.SaveChanges();
            return Ok(voucherUpdate);
        }

        [HttpDelete]
        public IActionResult DeleteVoucher(int id)
        {
            Voucher voucher = context.Vouchers.Find(id);
            if (voucher == null)
            {
                return NotFound("khong co voucher nao co id = " + id);
            }
            context.Vouchers.Remove(voucher);
            context.SaveChanges();
            var voucherList = context.Vouchers.ToList();
            return Ok(voucherList);
        }
    }
}
