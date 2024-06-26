USE [master]
GO
/****** Object:  Database [OnlineStoreDB]    Script Date: 6/16/2024 10:55:56 AM ******/
CREATE DATABASE [OnlineStoreDB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'OnlineStoreDB', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\OnlineStoreDB.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'OnlineStoreDB_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\OnlineStoreDB_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [OnlineStoreDB] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [OnlineStoreDB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [OnlineStoreDB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [OnlineStoreDB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [OnlineStoreDB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [OnlineStoreDB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [OnlineStoreDB] SET ARITHABORT OFF 
GO
ALTER DATABASE [OnlineStoreDB] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [OnlineStoreDB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [OnlineStoreDB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [OnlineStoreDB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [OnlineStoreDB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [OnlineStoreDB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [OnlineStoreDB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [OnlineStoreDB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [OnlineStoreDB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [OnlineStoreDB] SET  ENABLE_BROKER 
GO
ALTER DATABASE [OnlineStoreDB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [OnlineStoreDB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [OnlineStoreDB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [OnlineStoreDB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [OnlineStoreDB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [OnlineStoreDB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [OnlineStoreDB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [OnlineStoreDB] SET RECOVERY FULL 
GO
ALTER DATABASE [OnlineStoreDB] SET  MULTI_USER 
GO
ALTER DATABASE [OnlineStoreDB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [OnlineStoreDB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [OnlineStoreDB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [OnlineStoreDB] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [OnlineStoreDB] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [OnlineStoreDB] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'OnlineStoreDB', N'ON'
GO
ALTER DATABASE [OnlineStoreDB] SET QUERY_STORE = OFF
GO
USE [OnlineStoreDB]
GO
/****** Object:  Table [dbo].[Accounts]    Script Date: 6/16/2024 10:55:56 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Accounts](
	[AccountID] [int] IDENTITY(1,1) NOT NULL,
	[Username] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](255) NOT NULL,
	[RoleID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[AccountID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Brands]    Script Date: 6/16/2024 10:55:56 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Brands](
	[BrandID] [int] IDENTITY(1,1) NOT NULL,
	[BrandName] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[BrandID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 6/16/2024 10:55:56 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[CategoryID] [int] IDENTITY(1,1) NOT NULL,
	[CategoryName] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetails]    Script Date: 6/16/2024 10:55:56 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetails](
	[OrderDetailID] [int] IDENTITY(1,1) NOT NULL,
	[OrderID] [int] NOT NULL,
	[ProductID] [int] NOT NULL,
	[Quantity] [int] NOT NULL,
	[UnitPrice] [decimal](18, 2) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[OrderDetailID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 6/16/2024 10:55:56 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[OrderID] [int] IDENTITY(1,1) NOT NULL,
	[AccountID] [int] NOT NULL,
	[OrderDate] [datetime] NOT NULL,
	[TotalAmount] [decimal](18, 2) NOT NULL,
	[VoucherID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 6/16/2024 10:55:56 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[ProductID] [int] IDENTITY(1,1) NOT NULL,
	[ProductName] [nvarchar](100) NOT NULL,
	[BrandID] [int] NULL,
	[Price] [decimal](18, 2) NOT NULL,
	[Stock] [int] NOT NULL,
	[Description] [nvarchar](255) NULL,
	[CategoryID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 6/16/2024 10:55:56 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Roles](
	[RoleID] [int] IDENTITY(1,1) NOT NULL,
	[RoleName] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[RoleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Vouchers]    Script Date: 6/16/2024 10:55:56 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vouchers](
	[VoucherID] [int] IDENTITY(1,1) NOT NULL,
	[VoucherCode] [nvarchar](50) NOT NULL,
	[Discount] [decimal](18, 2) NOT NULL,
	[ExpiryDate] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[VoucherID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Accounts] ON 

INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [RoleID]) VALUES (1, N'admin', N'hashed_password_1', 1)
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [RoleID]) VALUES (2, N'employee', N'hashed_password_2', 2)
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [RoleID]) VALUES (3, N'customer1', N'hashed_password_3', 3)
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [RoleID]) VALUES (4, N'customer2', N'hashed_password_4', 3)
SET IDENTITY_INSERT [dbo].[Accounts] OFF
GO
SET IDENTITY_INSERT [dbo].[Brands] ON 

INSERT [dbo].[Brands] ([BrandID], [BrandName]) VALUES (1, N'Apple')
INSERT [dbo].[Brands] ([BrandID], [BrandName]) VALUES (2, N'Samsung')
SET IDENTITY_INSERT [dbo].[Brands] OFF
GO
SET IDENTITY_INSERT [dbo].[Categories] ON 

INSERT [dbo].[Categories] ([CategoryID], [CategoryName]) VALUES (1, N'Smartphones')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName]) VALUES (2, N'Accessories')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName]) VALUES (3, N'Tablets')
SET IDENTITY_INSERT [dbo].[Categories] OFF
GO
SET IDENTITY_INSERT [dbo].[OrderDetails] ON 

INSERT [dbo].[OrderDetails] ([OrderDetailID], [OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (1, 1, 1, 1, CAST(999.99 AS Decimal(18, 2)))
INSERT [dbo].[OrderDetails] ([OrderDetailID], [OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (2, 2, 2, 1, CAST(799.99 AS Decimal(18, 2)))
SET IDENTITY_INSERT [dbo].[OrderDetails] OFF
GO
SET IDENTITY_INSERT [dbo].[Orders] ON 

INSERT [dbo].[Orders] ([OrderID], [AccountID], [OrderDate], [TotalAmount], [VoucherID]) VALUES (1, 3, CAST(N'2024-05-30T08:42:46.803' AS DateTime), CAST(999.99 AS Decimal(18, 2)), 1)
INSERT [dbo].[Orders] ([OrderID], [AccountID], [OrderDate], [TotalAmount], [VoucherID]) VALUES (2, 4, CAST(N'2024-05-30T08:42:46.803' AS DateTime), CAST(799.99 AS Decimal(18, 2)), NULL)
SET IDENTITY_INSERT [dbo].[Orders] OFF
GO
SET IDENTITY_INSERT [dbo].[Products] ON 

INSERT [dbo].[Products] ([ProductID], [ProductName], [BrandID], [Price], [Stock], [Description], [CategoryID]) VALUES (1, N'iPhone 13', 1, CAST(999.99 AS Decimal(18, 2)), 10, N'Ði?n tho?i Apple iPhone 13', 1)
INSERT [dbo].[Products] ([ProductID], [ProductName], [BrandID], [Price], [Stock], [Description], [CategoryID]) VALUES (2, N'Galaxy S21', 2, CAST(799.99 AS Decimal(18, 2)), 15, N'Ði?n tho?i Samsung Galaxy S21', 1)
SET IDENTITY_INSERT [dbo].[Products] OFF
GO
SET IDENTITY_INSERT [dbo].[Roles] ON 

INSERT [dbo].[Roles] ([RoleID], [RoleName]) VALUES (1, N'Admin')
INSERT [dbo].[Roles] ([RoleID], [RoleName]) VALUES (2, N'Employee')
INSERT [dbo].[Roles] ([RoleID], [RoleName]) VALUES (3, N'Customer')
SET IDENTITY_INSERT [dbo].[Roles] OFF
GO
SET IDENTITY_INSERT [dbo].[Vouchers] ON 

INSERT [dbo].[Vouchers] ([VoucherID], [VoucherCode], [Discount], [ExpiryDate]) VALUES (1, N'DISCOUNT10', CAST(10.00 AS Decimal(18, 2)), CAST(N'2024-12-31T00:00:00.000' AS DateTime))
INSERT [dbo].[Vouchers] ([VoucherID], [VoucherCode], [Discount], [ExpiryDate]) VALUES (2, N'SUMMER20', CAST(20.00 AS Decimal(18, 2)), CAST(N'2024-06-30T00:00:00.000' AS DateTime))
SET IDENTITY_INSERT [dbo].[Vouchers] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Accounts__536C85E44C033F48]    Script Date: 6/16/2024 10:55:56 AM ******/
ALTER TABLE [dbo].[Accounts] ADD UNIQUE NONCLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Vouchers__7F0ABCA9526627E8]    Script Date: 6/16/2024 10:55:56 AM ******/
ALTER TABLE [dbo].[Vouchers] ADD UNIQUE NONCLUSTERED 
(
	[VoucherCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Orders] ADD  DEFAULT (getdate()) FOR [OrderDate]
GO
ALTER TABLE [dbo].[Accounts]  WITH CHECK ADD  CONSTRAINT [FK_Accounts_Roles] FOREIGN KEY([RoleID])
REFERENCES [dbo].[Roles] ([RoleID])
GO
ALTER TABLE [dbo].[Accounts] CHECK CONSTRAINT [FK_Accounts_Roles]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetails_Orders] FOREIGN KEY([OrderID])
REFERENCES [dbo].[Orders] ([OrderID])
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK_OrderDetails_Orders]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetails_Products] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Products] ([ProductID])
GO
ALTER TABLE [dbo].[OrderDetails] CHECK CONSTRAINT [FK_OrderDetails_Products]
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [FK_Orders_Accounts] FOREIGN KEY([AccountID])
REFERENCES [dbo].[Accounts] ([AccountID])
GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [FK_Orders_Accounts]
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [FK_Orders_Vouchers] FOREIGN KEY([VoucherID])
REFERENCES [dbo].[Vouchers] ([VoucherID])
GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [FK_Orders_Vouchers]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Products_Brands] FOREIGN KEY([BrandID])
REFERENCES [dbo].[Brands] ([BrandID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Products_Brands]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Products_Categories] FOREIGN KEY([CategoryID])
REFERENCES [dbo].[Categories] ([CategoryID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Products_Categories]
GO
USE [master]
GO
ALTER DATABASE [OnlineStoreDB] SET  READ_WRITE 
GO
