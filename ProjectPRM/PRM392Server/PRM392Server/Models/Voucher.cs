using System;
using System.Collections.Generic;

namespace PRM392Server.Models
{
    public partial class Voucher
    {
        public Voucher()
        {
            Orders = new HashSet<Order>();
        }

        public int VoucherId { get; set; }
        public string VoucherCode { get; set; } = null!;
        public decimal Discount { get; set; }
        public DateTime ExpiryDate { get; set; }

        public virtual ICollection<Order> Orders { get; set; }
    }
}
