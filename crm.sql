USE [BYZKHGX]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 05/02/2018 14:18:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Pwd] [nvarchar](50) NULL,
	[Roule] [nvarchar](50) NULL,
	[TName] [nvarchar](50) NULL,
	[Tel] [nvarchar](50) NULL,
	[Address] [nvarchar](50) NULL,
	[DepId] [int] NULL,
	[DepName] [nvarchar](50) NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Users] ON
INSERT [dbo].[Users] ([id], [Name], [Pwd], [Roule], [TName], [Tel], [Address], [DepId], [DepName]) VALUES (1, N'user1', N'user1', N'普通用户', N' 王晓', N'137515454', N'西安市', 3, N'人事部')
INSERT [dbo].[Users] ([id], [Name], [Pwd], [Roule], [TName], [Tel], [Address], [DepId], [DepName]) VALUES (2, N'admin', N'admin', N'管理员', N'王总', N'136545478', N'西安市', 1, N'系统管理部')
INSERT [dbo].[Users] ([id], [Name], [Pwd], [Roule], [TName], [Tel], [Address], [DepId], [DepName]) VALUES (3, N'jl001', N'jl001', N'经理', N'王鸿飞', N'1331212151', N'5撒打发士大夫多少', 3, N'人事部')
SET IDENTITY_INSERT [dbo].[Users] OFF
/****** Object:  Table [dbo].[TuiSong]    Script Date: 05/02/2018 14:18:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TuiSong](
	[id] [int] NOT NULL,
	[Name] [nvarchar](50) NULL,
	[DanJia] [float] NULL,
	[zuoze] [nvarchar](50) NULL,
	[zhiti] [nvarchar](50) NULL,
	[guige] [nvarchar](50) NULL,
	[beizhu] [text] NULL,
	[kehuyi] [nvarchar](50) NULL,
	[kehuer] [nvarchar](50) NULL,
	[yuangong] [nvarchar](50) NULL,
 CONSTRAINT [PK_TuiSong] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SurveyInfo]    Script Date: 05/02/2018 14:18:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SurveyInfo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[txtName] [nvarchar](50) NULL,
	[txtType] [nvarchar](50) NULL,
	[txtDs] [text] NULL,
	[AddTime] [datetime] NULL,
	[txtuserId] [int] NULL,
	[DepId] [int] NULL,
	[KHName] [nvarchar](50) NULL,
	[CaozuoYuan] [nvarchar](50) NULL,
	[yijian] [nvarchar](50) NULL,
 CONSTRAINT [PK_SurveyInfo] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[SurveyInfo] ON
INSERT [dbo].[SurveyInfo] ([id], [txtName], [txtType], [txtDs], [AddTime], [txtuserId], [DepId], [KHName], [CaozuoYuan], [yijian]) VALUES (3, N'1233', N'客户反馈', N'wqwrwerq', CAST(0x0000A76A00C5F5D2 AS DateTime), 1, 3, N'李鸿飞', N' 王晓', N'警告')
INSERT [dbo].[SurveyInfo] ([id], [txtName], [txtType], [txtDs], [AddTime], [txtuserId], [DepId], [KHName], [CaozuoYuan], [yijian]) VALUES (4, N'423', N'客户投诉', N'afdsafsdaq发全服', CAST(0x0000A77900EDC511 AS DateTime), 1, 3, N'王峰', N' 王晓', NULL)
INSERT [dbo].[SurveyInfo] ([id], [txtName], [txtType], [txtDs], [AddTime], [txtuserId], [DepId], [KHName], [CaozuoYuan], [yijian]) VALUES (5, N'3254', N'客户反馈', N'是大股东股份的公司入股', CAST(0x0000A77900EDD060 AS DateTime), 1, 3, N'王洪亮', N' 王晓', NULL)
INSERT [dbo].[SurveyInfo] ([id], [txtName], [txtType], [txtDs], [AddTime], [txtuserId], [DepId], [KHName], [CaozuoYuan], [yijian]) VALUES (6, N'5637', N'客户反馈', N'爱国福大好时光还是提示好好读书山东干二阿哥啊个人各地方噶让任刚而案发发阿发啊啊非法人', CAST(0x0000A77900EDE3ED AS DateTime), 1, 3, N'张新', N' 王晓', NULL)
INSERT [dbo].[SurveyInfo] ([id], [txtName], [txtType], [txtDs], [AddTime], [txtuserId], [DepId], [KHName], [CaozuoYuan], [yijian]) VALUES (7, N'567', N'客户反馈', N'东方故事的故事热热热给对方果然都是发发', CAST(0x0000A77900EDF56A AS DateTime), 1, 3, N'张新', N' 王晓', NULL)
INSERT [dbo].[SurveyInfo] ([id], [txtName], [txtType], [txtDs], [AddTime], [txtuserId], [DepId], [KHName], [CaozuoYuan], [yijian]) VALUES (8, N'673', N'客户投诉', N'哈啊台湾east一道题是的噶尔', CAST(0x0000A77900EE14E6 AS DateTime), 1, 3, N'王洪亮', N' 王晓', NULL)
SET IDENTITY_INSERT [dbo].[SurveyInfo] OFF
/****** Object:  Table [dbo].[OrderInfo]    Script Date: 05/02/2018 14:18:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderInfo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ShuLiang] [nvarchar](50) NULL,
	[KeHu] [nvarchar](50) NULL,
	[GoodsName] [nvarchar](50) NULL,
	[Ds] [text] NULL,
	[AddTime] [datetime] NULL,
	[Adduser] [nvarchar](50) NULL,
	[txtuserId] [int] NULL,
	[Zje] [float] NULL,
	[DJ] [float] NULL,
	[ChengBen] [float] NULL,
	[DanHao] [nvarchar](50) NULL,
	[CaozuoYuan] [nvarchar](50) NULL,
 CONSTRAINT [PK_OrderInfo] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[OrderInfo] ON
INSERT [dbo].[OrderInfo] ([id], [ShuLiang], [KeHu], [GoodsName], [Ds], [AddTime], [Adduser], [txtuserId], [Zje], [DJ], [ChengBen], [DanHao], [CaozuoYuan]) VALUES (3, N'2', N'张芳', N'望岳', N'戊二醛无', CAST(0x0000A76A00BF244F AS DateTime), N'admin', 1, 24000, 12000, 8000, N'201755113543', N'王总')
INSERT [dbo].[OrderInfo] ([id], [ShuLiang], [KeHu], [GoodsName], [Ds], [AddTime], [Adduser], [txtuserId], [Zje], [DJ], [ChengBen], [DanHao], [CaozuoYuan]) VALUES (4, N'3', N'王洪亮', N'望岳', N'玩儿', CAST(0x0000A76A00BF341B AS DateTime), N'admin', 3, 36000, 12000, 8000, N'201755113556', N'王总')
INSERT [dbo].[OrderInfo] ([id], [ShuLiang], [KeHu], [GoodsName], [Ds], [AddTime], [Adduser], [txtuserId], [Zje], [DJ], [ChengBen], [DanHao], [CaozuoYuan]) VALUES (5, N'1', N'李鸿飞', N'临石门', N'让他去', CAST(0x0000A77800FF6BDD AS DateTime), N'jl001', 2, 40000, 40000, 35000, N'2017519152940', N'王鸿飞')
INSERT [dbo].[OrderInfo] ([id], [ShuLiang], [KeHu], [GoodsName], [Ds], [AddTime], [Adduser], [txtuserId], [Zje], [DJ], [ChengBen], [DanHao], [CaozuoYuan]) VALUES (6, N'1', N'张芳', N'千字文', N'二位若群', CAST(0x0000A77801006615 AS DateTime), N'jl001', 1, 50000, 50000, 40000, N'2017519152958', N'王鸿飞')
INSERT [dbo].[OrderInfo] ([id], [ShuLiang], [KeHu], [GoodsName], [Ds], [AddTime], [Adduser], [txtuserId], [Zje], [DJ], [ChengBen], [DanHao], [CaozuoYuan]) VALUES (7, N'2', N'王峰', N'临石门', N'未确认', CAST(0x0000A77801007D37 AS DateTime), N'jl001', 4, 80000, 40000, 35000, N'2017519153332', N'王鸿飞')
INSERT [dbo].[OrderInfo] ([id], [ShuLiang], [KeHu], [GoodsName], [Ds], [AddTime], [Adduser], [txtuserId], [Zje], [DJ], [ChengBen], [DanHao], [CaozuoYuan]) VALUES (8, N'1', N'李鸿飞', N'兰亭集序', N'而问题', CAST(0x0000A7780100CE6F AS DateTime), N'jl001', 2, 26000, 26000, 20000, N'2017519153430', N'王鸿飞')
INSERT [dbo].[OrderInfo] ([id], [ShuLiang], [KeHu], [GoodsName], [Ds], [AddTime], [Adduser], [txtuserId], [Zje], [DJ], [ChengBen], [DanHao], [CaozuoYuan]) VALUES (9, N'1', N'王峰', N'陋室铭', N'戊二醛', CAST(0x0000A7780100E6D1 AS DateTime), N'jl001', 4, 36000, 36000, 30000, N'201751915351', N'王鸿飞')
INSERT [dbo].[OrderInfo] ([id], [ShuLiang], [KeHu], [GoodsName], [Ds], [AddTime], [Adduser], [txtuserId], [Zje], [DJ], [ChengBen], [DanHao], [CaozuoYuan]) VALUES (10, N'1', N'张新', N'临石门', N'去玩儿', CAST(0x0000A77801021B54 AS DateTime), N'admin', 5, 40000, 40000, 35000, N'2017519153930', N'王总')
SET IDENTITY_INSERT [dbo].[OrderInfo] OFF
/****** Object:  Table [dbo].[MoBan]    Script Date: 05/02/2018 14:18:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MoBan](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[FilePath] [nvarchar](50) NULL,
 CONSTRAINT [PK_MoBan] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[MoBan] ON
INSERT [dbo].[MoBan] ([id], [Name], [FilePath]) VALUES (3, N'模板1', N'19145053722.doc')
INSERT [dbo].[MoBan] ([id], [Name], [FilePath]) VALUES (4, N'采购合同模板', N'19145146962.doc')
INSERT [dbo].[MoBan] ([id], [Name], [FilePath]) VALUES (5, N'买卖合同模板', N'19145222850.doc')
INSERT [dbo].[MoBan] ([id], [Name], [FilePath]) VALUES (6, N'技术合同模板', N'19145322854.doc')
INSERT [dbo].[MoBan] ([id], [Name], [FilePath]) VALUES (7, N'仓储合同模板', N'19145420592.doc')
INSERT [dbo].[MoBan] ([id], [Name], [FilePath]) VALUES (8, N'委托合同模板', N'19145454970.doc')
INSERT [dbo].[MoBan] ([id], [Name], [FilePath]) VALUES (9, N'保管合同模板', N'1914563199.doc')
INSERT [dbo].[MoBan] ([id], [Name], [FilePath]) VALUES (11, N'52525', N'20142038430.doc')
SET IDENTITY_INSERT [dbo].[MoBan] OFF
/****** Object:  Table [dbo].[HeTongInfo]    Script Date: 05/02/2018 14:18:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HeTongInfo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[TitleS] [nvarchar](50) NULL,
	[KeHu] [nvarchar](50) NULL,
	[Ds] [text] NULL,
	[AddTime] [datetime] NULL,
	[DepId] [int] NULL,
	[txtuserId] [int] NULL,
	[ZhuangTai] [nvarchar](50) NULL,
	[JIne] [nvarchar](50) NULL,
	[QDDAte] [nvarchar](50) NULL,
	[ZXDate] [nvarchar](50) NULL,
	[JSDate] [nvarchar](50) NULL,
	[ZXInfo] [nvarchar](50) NULL,
	[FilePath] [nvarchar](50) NULL,
	[LeiXing] [nvarchar](50) NULL,
	[CaozuoYuan] [nvarchar](50) NULL,
 CONSTRAINT [PK_TSInfo] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[HeTongInfo] ON
INSERT [dbo].[HeTongInfo] ([id], [TitleS], [KeHu], [Ds], [AddTime], [DepId], [txtuserId], [ZhuangTai], [JIne], [QDDAte], [ZXDate], [JSDate], [ZXInfo], [FilePath], [LeiXing], [CaozuoYuan]) VALUES (3, N'234       ', N'张芳', N'而其他', CAST(0x0000A76A00C08DF2 AS DateTime), 1, 2, NULL, N'12000', N'2017-05-01', N'2017-05-03', N'2017-05-31', N'已经完成', N'5114059273.doc', N'买卖合同', N'王总')
INSERT [dbo].[HeTongInfo] ([id], [TitleS], [KeHu], [Ds], [AddTime], [DepId], [txtuserId], [ZhuangTai], [JIne], [QDDAte], [ZXDate], [JSDate], [ZXInfo], [FilePath], [LeiXing], [CaozuoYuan]) VALUES (4, N'书法保管', N'李鸿飞', N'去玩儿认为', CAST(0x0000A77801028A24 AS DateTime), 3, 3, NULL, N'5000', N'2017-05-15', N'2017-05-23', N'2017-05-30', N'等待执行', N'19154113723.doc', N'保管合同', NULL)
INSERT [dbo].[HeTongInfo] ([id], [TitleS], [KeHu], [Ds], [AddTime], [DepId], [txtuserId], [ZhuangTai], [JIne], [QDDAte], [ZXDate], [JSDate], [ZXInfo], [FilePath], [LeiXing], [CaozuoYuan]) VALUES (5, N'31121', N'李鸿飞', N'我去二统一人头', CAST(0x0000A778010330D5 AS DateTime), 1, 2, NULL, N'7000', N'2017-05-02', N'2017-05-08', N'2017-05-18', N'已经完成', N'1915433513.doc', N'技术合同', N'王总')
INSERT [dbo].[HeTongInfo] ([id], [TitleS], [KeHu], [Ds], [AddTime], [DepId], [txtuserId], [ZhuangTai], [JIne], [QDDAte], [ZXDate], [JSDate], [ZXInfo], [FilePath], [LeiXing], [CaozuoYuan]) VALUES (6, N'434', N'张芳', N'dagge', CAST(0x0000A779011A337B AS DateTime), 1, 2, NULL, N'2000', N'2017-05-08', N'2017-05-24', N'2017-05-31', N'等待执行', N'', N'仓储合同', NULL)
INSERT [dbo].[HeTongInfo] ([id], [TitleS], [KeHu], [Ds], [AddTime], [DepId], [txtuserId], [ZhuangTai], [JIne], [QDDAte], [ZXDate], [JSDate], [ZXInfo], [FilePath], [LeiXing], [CaozuoYuan]) VALUES (7, N'43545', N'王超', N'顺丰速运他会发光小户型', CAST(0x0000A779011A5C0F AS DateTime), 1, 2, NULL, N'100000', N'2017-03-13', N'2017-04-18', N'2017-05-18', N'已经完成', N'', N'其他合同', NULL)
INSERT [dbo].[HeTongInfo] ([id], [TitleS], [KeHu], [Ds], [AddTime], [DepId], [txtuserId], [ZhuangTai], [JIne], [QDDAte], [ZXDate], [JSDate], [ZXInfo], [FilePath], [LeiXing], [CaozuoYuan]) VALUES (8, N'89568', N'张新', N'喜欢和方法好像有人讨厌是', CAST(0x0000A779011ADB2F AS DateTime), 1, 2, NULL, N'3000', N'2017-05-09', N'2017-06-08', N'2017-06-30', N'等待执行', N'', N'委托合同', NULL)
INSERT [dbo].[HeTongInfo] ([id], [TitleS], [KeHu], [Ds], [AddTime], [DepId], [txtuserId], [ZhuangTai], [JIne], [QDDAte], [ZXDate], [JSDate], [ZXInfo], [FilePath], [LeiXing], [CaozuoYuan]) VALUES (9, N'65769', N'王洪亮', N'所有同仁堂你又有哪些', CAST(0x0000A779011B3907 AS DateTime), 1, 2, NULL, N'8000', N'2017-05-03', N'2017-05-27', N'2017-06-03', N'等待执行', N'', N'买卖合同', NULL)
SET IDENTITY_INSERT [dbo].[HeTongInfo] OFF
/****** Object:  Table [dbo].[Goods]    Script Date: 05/02/2018 14:18:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Goods](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[DanJia] [float] NULL,
	[GuiGe] [nvarchar](50) NULL,
	[BeiZhu] [text] NULL,
	[ChengBen] [float] NULL,
	[ZhenZhi] [nvarchar](50) NULL,
	[YanSe] [nvarchar](50) NULL,
	[MaShu] [nvarchar](50) NULL,
	[KeHu] [nvarchar](50) NULL,
	[YuanGong] [nvarchar](50) NULL,
 CONSTRAINT [PK_Goods] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Goods] ON
INSERT [dbo].[Goods] ([id], [Name], [DanJia], [GuiGe], [BeiZhu], [ChengBen], [ZhenZhi], [YanSe], [MaShu], [KeHu], [YuanGong]) VALUES (2, N'望岳', 12000, N'201705200001', N'231', 8000, N'钱松君', N'正楷', N'八尺条幅（12平尺）', N'张芳', N' 王晓')
INSERT [dbo].[Goods] ([id], [Name], [DanJia], [GuiGe], [BeiZhu], [ChengBen], [ZhenZhi], [YanSe], [MaShu], [KeHu], [YuanGong]) VALUES (3, N'东坡题画诗', 10000, N'201705200002', N'而台湾', 8000, N'钱松君', N'隶书', N'八尺条幅（12平尺）', N'王洪亮', N' 王晓')
INSERT [dbo].[Goods] ([id], [Name], [DanJia], [GuiGe], [BeiZhu], [ChengBen], [ZhenZhi], [YanSe], [MaShu], [KeHu], [YuanGong]) VALUES (4, N'临石门', 40000, N'201705200003', N'特天气你', 35000, N'钱松君', N'铭文', N'八尺四条（48平尺）', N'张新', N'王鸿飞')
INSERT [dbo].[Goods] ([id], [Name], [DanJia], [GuiGe], [BeiZhu], [ChengBen], [ZhenZhi], [YanSe], [MaShu], [KeHu], [YuanGong]) VALUES (5, N'小石潭记', 36000, N'201705200004', N'23232 发给', 30000, N'钱松君', N'正楷', N'六尺四条', N'王峰', N'王鸿飞')
INSERT [dbo].[Goods] ([id], [Name], [DanJia], [GuiGe], [BeiZhu], [ChengBen], [ZhenZhi], [YanSe], [MaShu], [KeHu], [YuanGong]) VALUES (7, N'兰亭集序', 26000, N'201705200005', N'发广告染发剂土黄色', 20000, N'鞠闻天', N'隶书', N'四尺四条', NULL, NULL)
INSERT [dbo].[Goods] ([id], [Name], [DanJia], [GuiGe], [BeiZhu], [ChengBen], [ZhenZhi], [YanSe], [MaShu], [KeHu], [YuanGong]) VALUES (8, N'道德经', 150000, N'201705260001', N'为广大发光时代额', 120000, N'钱松君', N'隶书', N'5米长卷', NULL, NULL)
INSERT [dbo].[Goods] ([id], [Name], [DanJia], [GuiGe], [BeiZhu], [ChengBen], [ZhenZhi], [YanSe], [MaShu], [KeHu], [YuanGong]) VALUES (9, N'千字文', 50000, N'201705260002', N'而儿童给对方是个', 40000, N'钱松君', N'隶书', N'12帧册', NULL, NULL)
INSERT [dbo].[Goods] ([id], [Name], [DanJia], [GuiGe], [BeiZhu], [ChengBen], [ZhenZhi], [YanSe], [MaShu], [KeHu], [YuanGong]) VALUES (10, N'般若波罗蜜多心经', 12000, N'201705260003', N'一个覅语购房应付', 9000, N'鞠闻天', N'隶书', N'四尺条幅', NULL, NULL)
INSERT [dbo].[Goods] ([id], [Name], [DanJia], [GuiGe], [BeiZhu], [ChengBen], [ZhenZhi], [YanSe], [MaShu], [KeHu], [YuanGong]) VALUES (11, N'陋室铭', 36000, N'201705260004', N'更好地与房产价格', 30000, N'鞠闻天', N'行书', N'六尺四条', NULL, NULL)
INSERT [dbo].[Goods] ([id], [Name], [DanJia], [GuiGe], [BeiZhu], [ChengBen], [ZhenZhi], [YanSe], [MaShu], [KeHu], [YuanGong]) VALUES (12, N'论语', 60000, N'201705260005', N'噶东风read鬼地方噶', 50000, N'钱松君', N'正楷', N'12帧册', NULL, NULL)
SET IDENTITY_INSERT [dbo].[Goods] OFF
/****** Object:  Table [dbo].[DepInfo]    Script Date: 05/02/2018 14:18:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DepInfo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
 CONSTRAINT [PK_DepInfo] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[DepInfo] ON
INSERT [dbo].[DepInfo] ([id], [Name]) VALUES (1, N'系统管理部')
INSERT [dbo].[DepInfo] ([id], [Name]) VALUES (2, N'销售一部')
INSERT [dbo].[DepInfo] ([id], [Name]) VALUES (3, N'人事部')
SET IDENTITY_INSERT [dbo].[DepInfo] OFF
/****** Object:  Table [dbo].[CustomerInfo]    Script Date: 05/02/2018 14:18:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CustomerInfo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[txtName] [nvarchar](50) NULL,
	[txtType] [nvarchar](50) NULL,
	[txtHyType] [nvarchar](50) NULL,
	[txtFZR] [nvarchar](50) NULL,
	[txtSex] [nvarchar](10) NULL,
	[txtQYType] [nvarchar](50) NULL,
	[txtAge] [nvarchar](10) NULL,
	[txtCD] [nvarchar](10) NULL,
	[txttel] [nvarchar](50) NULL,
	[txtKHJB] [nvarchar](50) NULL,
	[txtemal] [nvarchar](50) NULL,
	[txtQY] [nvarchar](50) NULL,
	[txtaddress] [nvarchar](200) NULL,
	[txtSite] [nvarchar](100) NULL,
	[TypeName] [nvarchar](50) NULL,
	[txtPic] [nvarchar](100) NULL,
	[txtDs] [text] NULL,
	[DepId] [int] NULL,
	[txtuserId] [int] NULL,
	[ShengRi] [nvarchar](50) NULL,
 CONSTRAINT [PK_CustomerInfo] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[CustomerInfo] ON
INSERT [dbo].[CustomerInfo] ([id], [txtName], [txtType], [txtHyType], [txtFZR], [txtSex], [txtQYType], [txtAge], [txtCD], [txttel], [txtKHJB], [txtemal], [txtQY], [txtaddress], [txtSite], [TypeName], [txtPic], [txtDs], [DepId], [txtuserId], [ShengRi]) VALUES (1, N'张芳', N'国企', N'无', N'李红', N'女', N'合伙企业', N'32', N'非常重要', N'1378487787', N'VIP客户', N'1215145@qq.com', N'陕西省', N'234234', N'士大夫似的', N'一般客户', N'16161245337.jpg', N'士大夫士大夫士大夫似的', 1, 2, NULL)
INSERT [dbo].[CustomerInfo] ([id], [txtName], [txtType], [txtHyType], [txtFZR], [txtSex], [txtQYType], [txtAge], [txtCD], [txttel], [txtKHJB], [txtemal], [txtQY], [txtaddress], [txtSite], [TypeName], [txtPic], [txtDs], [DepId], [txtuserId], [ShengRi]) VALUES (2, N'李鸿飞', N'国企', N'无', N'李鸿飞', N'男', N'合伙企业', N'32', N'非常重要', N'1378487787', N'VIP客户', N'1215145@qq.com', N'陕西省', N'234234', N'士大夫似的', N'一般客户', N'16161245337.jpg', N'士大夫士大夫士大夫似的', 1, 2, NULL)
INSERT [dbo].[CustomerInfo] ([id], [txtName], [txtType], [txtHyType], [txtFZR], [txtSex], [txtQYType], [txtAge], [txtCD], [txttel], [txtKHJB], [txtemal], [txtQY], [txtaddress], [txtSite], [TypeName], [txtPic], [txtDs], [DepId], [txtuserId], [ShengRi]) VALUES (3, N'王洪亮', N'国企', N'无', N'王洪亮', N'男', N'合伙企业', N'32', N'非常重要', N'1378487787', N'VIP客户', N'1215145@qq.com', N'陕西省', N'234234', N'士大夫似的', N'一般客户', N'16161245337.jpg', N'士大夫士大夫士大夫似的', 1, 2, NULL)
INSERT [dbo].[CustomerInfo] ([id], [txtName], [txtType], [txtHyType], [txtFZR], [txtSex], [txtQYType], [txtAge], [txtCD], [txttel], [txtKHJB], [txtemal], [txtQY], [txtaddress], [txtSite], [TypeName], [txtPic], [txtDs], [DepId], [txtuserId], [ShengRi]) VALUES (4, N'王峰', N'国企', N'无', N'王峰', N'男', N'合伙企业', N'32', N'非常重要', N'1378487787', N'VIP客户', N'1215145@qq.com', N'陕西省', N'234234', N'士大夫似的', N'一般客户', N'16161245337.jpg', N'士大夫士大夫士大夫似的', 1, 2, NULL)
INSERT [dbo].[CustomerInfo] ([id], [txtName], [txtType], [txtHyType], [txtFZR], [txtSex], [txtQYType], [txtAge], [txtCD], [txttel], [txtKHJB], [txtemal], [txtQY], [txtaddress], [txtSite], [TypeName], [txtPic], [txtDs], [DepId], [txtuserId], [ShengRi]) VALUES (5, N'张新', NULL, N'水电局', NULL, N'男', NULL, N'企事业', N'非常重要', N'13789763512', N'客户', N'1215145@qq.com', N'陕西省', N'西安雁塔区', NULL, N'一般客户', N'19153813766.jpg', N'阿飞飞舞', 3, 3, N'1979-03-21')
INSERT [dbo].[CustomerInfo] ([id], [txtName], [txtType], [txtHyType], [txtFZR], [txtSex], [txtQYType], [txtAge], [txtCD], [txttel], [txtKHJB], [txtemal], [txtQY], [txtaddress], [txtSite], [TypeName], [txtPic], [txtDs], [DepId], [txtuserId], [ShengRi]) VALUES (7, N'王宇超', NULL, N'平安保险', NULL, N'男', NULL, N'保险', N'重要', N'12134345121', N'客户', N'562323@qq.com', N'陕西省', N'西安户县', NULL, N'一般客户', N'', N'公司的公告啊防守打法', 3, 1, N'1962-10-23')
SET IDENTITY_INSERT [dbo].[CustomerInfo] OFF
/****** Object:  Default [DF_TSInfo_AddTime]    Script Date: 05/02/2018 14:18:11 ******/
ALTER TABLE [dbo].[HeTongInfo] ADD  CONSTRAINT [DF_TSInfo_AddTime]  DEFAULT (getdate()) FOR [AddTime]
GO
/****** Object:  Default [DF_OrderInfo_AddTime]    Script Date: 05/02/2018 14:18:11 ******/
ALTER TABLE [dbo].[OrderInfo] ADD  CONSTRAINT [DF_OrderInfo_AddTime]  DEFAULT (getdate()) FOR [AddTime]
GO
/****** Object:  Default [DF_SurveyInfo_AddTime]    Script Date: 05/02/2018 14:18:11 ******/
ALTER TABLE [dbo].[SurveyInfo] ADD  CONSTRAINT [DF_SurveyInfo_AddTime]  DEFAULT (getdate()) FOR [AddTime]
GO
