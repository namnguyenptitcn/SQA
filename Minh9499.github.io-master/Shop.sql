USE [QL_CHANG]
GO
/****** Object:  Table [dbo].[loai_sp]    Script Date: 02/06/2021 11:45:56 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[loai_sp](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ten_loai] [nvarchar](255) NULL,
	[ghi_chu] [nvarchar](255) NULL,
	[ngay_tao] [date] NULL,
 CONSTRAINT [PK__loai_sp__3213E83F7EBE5370] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[nhan_vien]    Script Date: 02/06/2021 11:45:56 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[nhan_vien](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ten] [nvarchar](50) NULL,
	[sdt] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
	[dia_chi] [nvarchar](max) NULL,
	[vai_tro] [nvarchar](50) NULL,
	[ngay_tao] [date] NULL,
 CONSTRAINT [PK__nhan_vie__3213E83F7AEC997B] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[loai_sp] ON 

INSERT [dbo].[loai_sp] ([id], [ten_loai], [ghi_chu], [ngay_tao]) VALUES (1, N'Tủ Lạnh', N'Tủ lạnh siêu nóng', CAST(N'2021-04-04' AS Date))
INSERT [dbo].[loai_sp] ([id], [ten_loai], [ghi_chu], [ngay_tao]) VALUES (2, N'Chảo', N'Chảo chống dính', CAST(N'2021-04-04' AS Date))
INSERT [dbo].[loai_sp] ([id], [ten_loai], [ghi_chu], [ngay_tao]) VALUES (3, N'PC', N'Siêu máy tính', CAST(N'2021-04-04' AS Date))
INSERT [dbo].[loai_sp] ([id], [ten_loai], [ghi_chu], [ngay_tao]) VALUES (4, N'Máy in', N'Máy in không ra mực', CAST(N'2021-04-04' AS Date))
SET IDENTITY_INSERT [dbo].[loai_sp] OFF
GO
SET IDENTITY_INSERT [dbo].[nhan_vien] ON 

INSERT [dbo].[nhan_vien] ([id], [ten], [sdt], [email], [dia_chi], [vai_tro], [ngay_tao]) VALUES (1, N'Minh', N'0969341099', N'nqm0904@gmail.com', N'Hà Nội', N'Stu', CAST(N'2021-01-04' AS Date))
INSERT [dbo].[nhan_vien] ([id], [ten], [sdt], [email], [dia_chi], [vai_tro], [ngay_tao]) VALUES (2, N'sun', N'0969341021', N'sun@gmail.com', N'TP HCM', N'Stu', CAST(N'2021-02-04' AS Date))
INSERT [dbo].[nhan_vien] ([id], [ten], [sdt], [email], [dia_chi], [vai_tro], [ngay_tao]) VALUES (3, N'Nam', N'0932032320', N'Nam@gmail.com', N'Hà Nội', N'Te', CAST(N'2021-03-04' AS Date))
INSERT [dbo].[nhan_vien] ([id], [ten], [sdt], [email], [dia_chi], [vai_tro], [ngay_tao]) VALUES (4, N'Mạnh', N'0969341099', N'Manh@gmail.com', N'Hà Nội', N'Stu', CAST(N'2021-04-04' AS Date))
SET IDENTITY_INSERT [dbo].[nhan_vien] OFF
GO
