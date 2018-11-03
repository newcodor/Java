/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50173
Source Host           : 127.0.0.1:3306
Source Database       : db_novel

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-11-04 00:02:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `role` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `lastip` varchar(30) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`adminid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '123', '1', 'admin@qiuxiaoshuo.com', '127.0.0.1', '2018-05-02 23:10:29');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `bookname` varchar(200) DEFAULT NULL,
  `bookintroduction` varchar(1000) DEFAULT NULL,
  `status` varchar(30) NOT NULL DEFAULT '连载',
  `cid` int(20) DEFAULT NULL,
  `posttime` date DEFAULT NULL,
  `postip` varchar(30) NOT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '10', '圣墟', '在破败中崛起，在寂灭中复苏。\r\n　　沧海成尘，雷电枯竭，那一缕幽雾又一次临近大地，世间的枷锁被打开了，一个全新的世界就此揭开神秘的一角……', '连载', '1', '2018-04-14', '0:0:0:0:0:0:0:1');
INSERT INTO `book` VALUES ('15', '3', '幻想世界大穿越', '当幻想成为现实，天朝少年能否踏上成神之路？拥有穿越异能的陈昂，穿越在幻想世界里。在《永无止境》的世界里，获得超人的智慧，在《超体》的世界里，窥视成神的奥秘，从《笑傲江湖》开始，修行内功，进化自己，由《狂蟒之灾》中，拿到长生的钥匙，超人血清，绝境药剂，X因子，蜘蛛基因，蜥蜴药剂嗑药成神的道路漫长而崎岖，窥视上帝的禁区危险而艰难，我一路不悔！', '连载', '4', '2018-06-06', '127.0.0.1');
INSERT INTO `book` VALUES ('16', '3', '武侠世界大冒险', '王动在玩一款武侠游戏的时候，穿到了古代，变为了一个江湖帮派弟子。咦！竟然被游戏上了身，可以通过游戏自由出入“金古黄”为主导的武侠位面？而且当成为位面第一高手时，还能将小说角色带到现实？哈哈哈，王动仰天大笑，这下想不发达都难了！纵马江湖道，今生任逍遥，豪情不为红颜折腰，来吧，再来回味一番那个曾经的江湖。', '连载', '2', '2018-06-06', '127.0.0.1');
INSERT INTO `book` VALUES ('4', '11', '电影世界穿梭门', '那一天，一道天雷劈下，王旭没有穿越，他家的大门穿越了。电影，电视剧，动漫，远古神话，这里有无尽的时空，也意味着无尽的可能....2', '连载', '3', '2018-03-28', '0:0:0:0:0:0:0:1');
INSERT INTO `book` VALUES ('5', '11', '1998', '大时代', '连载', '3', '2018-02-28', '0:0:0:0:0:0:0:1');
INSERT INTO `book` VALUES ('6', '5', '牧神记 ', '心潮澎湃，无限幻想，迎风挥击千层浪，少年不败热血！', '已完本', '1', '2018-05-29', '0:0:0:0:0:0:0:1');
INSERT INTO `book` VALUES ('14', '5', '位面破坏神', '武侠、动漫、仙侠，历经各个位面。以破界珠为本，以大执念为宗，破碎万界，随心所欲。', '连载', '3', '2018-05-31', '0:0:0:0:0:0:0:1');
INSERT INTO `book` VALUES ('17', '5', '重生之超神黑客　', '超级黑客唐枫，因为命运的玩笑重生在了2003年，这是一个互联网刚刚起步的时代，他利用自己的特长，与牛人为伍，开公司，做游戏，玩音乐，你不服，我用超前的技术玩死你，玩你没有玩过的，玩你没有见过的，低调，低调，你才20岁。', '已完本', '6', '2018-06-06', '127.0.0.1');
INSERT INTO `book` VALUES ('18', '10', '不死不灭', '一个被称为魔的人，为了生存而苦苦挣扎，最后走上了一条抗天之路……', '连载', '2', '2018-06-06', '127.0.0.1');
INSERT INTO `book` VALUES ('19', '10', '遮天', '冰冷与黑暗并存的宇宙深处，九具庞大的龙尸拉着一口青铜古棺，亘古长存。这是太空探测器在枯寂的宇宙中捕捉到的一幅极其震撼的画面。九龙拉棺，究竟是回到了上古，还是来到了星空的彼岸？一个浩大的仙侠世界，光怪陆离，神秘无尽。热血似火山沸腾，激情若瀚海汹涌，欲望如深渊无止境……登天路，踏歌行，弹指遮天。', '连载', '2', '2018-06-06', '127.0.0.1');
INSERT INTO `book` VALUES ('20', '10', '神墓', '一个死去万载岁月的平凡青年从远古神墓中复活而出……', '连载', '1', '2018-06-06', '127.0.0.1');
INSERT INTO `book` VALUES ('21', '11', '降临诸天世界', '说圣人，谁是圣人。大圣不圣，大魔难神。电影、动漫、小说、魔法，远古神话......踏足周天，行走万界。', '连载', '3', '2018-06-06', '127.0.0.1');
INSERT INTO `book` VALUES ('22', '7', '31242', 'ewaerwqvewr', '连载', '2', '2018-06-06', '127.0.0.1');

-- ----------------------------
-- Table structure for bookmark
-- ----------------------------
DROP TABLE IF EXISTS `bookmark`;
CREATE TABLE `bookmark` (
  `bmid` int(11) NOT NULL AUTO_INCREMENT,
  `bid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `chaid` int(11) DEFAULT NULL,
  `addTime` date DEFAULT NULL,
  PRIMARY KEY (`bmid`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bookmark
-- ----------------------------
INSERT INTO `bookmark` VALUES ('16', '14', '5', '27', '2018-06-06');
INSERT INTO `bookmark` VALUES ('17', '1', '5', '42', '2018-06-06');

-- ----------------------------
-- Table structure for bookself
-- ----------------------------
DROP TABLE IF EXISTS `bookself`;
CREATE TABLE `bookself` (
  `bsid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `bid` int(11) DEFAULT NULL,
  `addTime` date DEFAULT NULL,
  PRIMARY KEY (`bsid`)
) ENGINE=MyISAM AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bookself
-- ----------------------------
INSERT INTO `bookself` VALUES ('68', '5', '21', '2018-06-06');
INSERT INTO `bookself` VALUES ('69', '5', '16', '2018-06-06');
INSERT INTO `bookself` VALUES ('70', '5', '1', '2018-06-06');
INSERT INTO `bookself` VALUES ('71', '7', '15', '2018-06-06');
INSERT INTO `bookself` VALUES ('72', '7', '14', '2018-06-06');
INSERT INTO `bookself` VALUES ('73', '7', '6', '2018-06-06');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `categoryname` varchar(30) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '玄幻魔法', '2018-04-14 16:10:49');
INSERT INTO `category` VALUES ('2', '武侠修真', '2018-04-12 16:11:08');
INSERT INTO `category` VALUES ('3', '科幻穿越', '2018-04-15 16:11:25');
INSERT INTO `category` VALUES ('4', '历史架空', '2018-04-14 16:11:54');
INSERT INTO `category` VALUES ('6', '都市言情', '2018-05-03 21:13:14');

-- ----------------------------
-- Table structure for chapter
-- ----------------------------
DROP TABLE IF EXISTS `chapter`;
CREATE TABLE `chapter` (
  `chaid` int(11) NOT NULL AUTO_INCREMENT,
  `bid` int(11) NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `contents` varchar(5000) DEFAULT NULL,
  `posttime` date DEFAULT NULL,
  PRIMARY KEY (`chaid`)
) ENGINE=MyISAM AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chapter
-- ----------------------------
INSERT INTO `chapter` VALUES ('1', '1', '第一章 沙漠中的彼岸花', '<br/>　　大漠孤烟直，长河落日圆。<br/>　　一望无垠的大漠，空旷而高远，壮阔而雄浑，当红日西坠，地平线尽头一片殷红，磅礴中亦有种苍凉感。<br/>　　上古的烽烟早已在岁月中逝去，黄河古道虽然几经变迁，但依旧在。<br/>　　楚风一个人在旅行，很疲惫，他躺在黄沙上，看着血色的夕阳，不知道还要多久才能离开这片大漠。<br/>　　数日前他毕业了，同时也跟校园中的女神说再见，或许见不到了吧，毕竟他曾被委婉的告知，从此天各一方，该分手了。<br/>　　离开学院后，他便出来旅行。<br/>　　落日很红，挂在大漠的尽头，在空旷中有一种宁静的美。<br/>　　楚风坐起来喝了一些水，感觉精力恢复了不少，他的身体属于修长强健那一类型，体质非常好，疲惫渐消退。<br/>　　站起来眺望，他觉得快要离开大漠了，再走一段路程或许就会见到牧民的帐篷，他决定继续前行。<br/>　　一路西进，他在大漠中留下一串很长、很远的脚印。<br/>　　无声无息，竟起雾了，这在沙漠中非常罕见。<br/>　　楚风惊讶，而这雾竟然是蓝色的，在这深秋季节给人一种凉意。<br/>　　不知不觉间，雾霭渐重，蓝色缭绕，朦朦胧胧，笼罩了这片沙漠。<br/>　　大漠尽头，落日都显得有些诡异了，渐渐化成一轮蓝日，有种魔性的美，而火云也被染成了蓝色。<br/>　　楚风皱眉，虽然他知道，沙漠的天气最是多变，但眼前实在不太正常。<br/>　　一片寂静，他停下脚步。<br/>　　在进大漠前，他曾听当地的老牧民讲过，一个人走在沙漠中，有时会听到一些古怪的声音，会见到一些奇异的东西，要格外谨慎。<br/>　　当时他并未在意。<br/>　　依旧宁静，沙漠中除却多了一层朦胧的蓝雾，并没有其他变故发生，楚风加快脚步，他想尽快离开这里。<br/>　　大漠的尽头，落日蓝的妖异，染蓝了西部的天空，不过它终究快要消失在地平线上了。<br/>　　楚风的速度越来越快，开始奔跑，他不想呆在这种诡异、充满不确定性的地方。<br/>　　在沙漠中，海市蜃楼那样的奇景多发生在烈日当空下，眼下不相符，这不像是什么蜃景。<br/>　　突然，前面传来轻响，像是有什么东西破沙而出，而且声音很密集，此起彼伏。<br/>　　楚风倏地停下脚步，盯着沙漠，前方地面蓝光星星点点，像是散落一地蓝钻，晶莹透亮，在落日的余晖中闪耀着。<br/>　　那是一棵又一棵嫩苗，不足一寸高，自沙漠中破土而出，带着美丽的光泽，剔透而妖异，遍地皆是。<br/>　　短暂的停滞，随后沙沙声成片，蓝色灿灿，所有嫩苗都快速拔高，一瞬间生长起来。<br/>　　天边，蓝日下沉，即将消失，雾气弥漫，浩瀚的大漠如同披上了一层诡异的蓝色薄纱。<br/>　', '2018-04-01');
INSERT INTO `chapter` VALUES ('2', '1', '第二章 后文明时代', '牛羊等牲畜疑似受惊，差点闯出栅栏，牧民阻拦，大声喝斥着，平日间几头很凶的藏獒此时低伏在地，嘶吼着，很不安。\r\n　　同时还有孩子在哭泣，女人在安抚。\r\n　　有几名老牧民在祷告，很虔诚，最后更是跪下，朝着远方的高大山脉叩首，非常郑重。\r\n　　对于楚风的到来，牧民并不吃惊，因为经常有外来者路过，借宿牧民的帐篷中。\r\n　　很长时间后，山脚下的嘈杂声才变弱。\r\n　　楚风用热水擦洗过身体，喝着浓香的酥油茶，身上的疲惫顿时消退不少，他将身上所有的糖果都送给了孩子们。\r\n　　几个孩子小脸红扑扑，那是高原红，带着腼腆的笑，看起来非常淳朴，分完糖果后一哄而散，很快乐与满足。\r\n　　不久前这片山地究竟发生了什么，这是楚风心中的疑问，难道这里也曾经盛开近乎妖异的蓝色彼岸花？\r\n　　帐篷中的老牧民头发花白，脸上皱纹很深，带着明显的忧色，他看向帐篷外，凝视着远方的山脉。\r\n　　很快，楚风得悉，这里果真也出现过蓝雾，在山地中缭绕，许多牲畜都因此受惊，表现的非常暴躁，想要逃离。\r\n　　不过，并没有诡异的蓝色彼岸花，且雾气很稀薄。\r\n　　“您为什么要向山中叩首？”楚风问道。\r\n　　“那是圣山的方向。”老牧民答道。。。', '2018-04-02');
INSERT INTO `chapter` VALUES ('3', '1', '第三章 青铜昆仑', '“当！”\r\n　　青铜颤音震动，带着岁月的沧桑感。\r\n　　楚风放下手中的石块，确信这是铜碑无疑，这让他有些难以置信，数千斤重的青铜古器，这可不是小事。\r\n　　如果传出去的话，肯定会引起轰动。\r\n　　上面刻着西王二字，带着时光的沉淀，古朴中亦有神秘，吸引人的心神，真不知道是何年代所留。\r\n　　“什么人将它埋在昆仑山中？”\r\n　　楚风敲打铜碑，金属颤音不断，可惜他并不是考古者，得不出什么有价值的结论。\r\n　　“或许漫长岁月前这里曾经有一个极其辉煌的青铜文明。”他自语，这般推测。\r\n　　他一向不迷信，即便昆仑有着太多的神话色彩，并且突兀见到刻有西王二字的青铜巨碑，他也不怎么相信那些传说。', '2018-04-03');
INSERT INTO `chapter` VALUES ('4', '1', '第四章 奇树与猛兽', '昆仑山顶，最高崖壁处，一株三尺小树独自生长。\r\n　　视青铜为土壤，作养料，顽强扎根，通体绿莹莹，带着光泽。\r\n　　树干有手腕粗细，它虽不高大，但却带着老树皮，张裂着，如同一层层鳞片，竟有苍劲感。\r\n　　它的叶片如同绿玉雕刻而成，通透中富有灵性，形状如同幼儿的手掌，托着一些晶莹的露珠，清风拂过时，如同洁白珍珠在碧玉盘上滚动。\r\n　　在小树的顶端长有一个花骨朵，拳头大，通体银白，但带着金斑，于绝壁中待放，已经清香飘漾，很美。\r\n　　妖异的小树，静静傲立着。', '2018-04-04');
INSERT INTO `chapter` VALUES ('34', '15', '第六章五大奇功', '<div style=\"text-align: justify;\">藏在暗处的木高峰因为相貌丑陋，身体残疾，长期受人歧视，久而久之心性扭曲，为人心胸狭窄，他和林平之两人被藏在暗处把之前的事情都看在了眼里。木高峰见到陈昂的暗器如此犀利，脑子一转，就想到了一股毒计。</div><div style=\"text-align: justify;\">他让林平之过去叫骂，自己在暗中挑拨，要使陈昂和余沧海之间撕破脸皮，最好把五岳剑派也卷进来，让衡山城的水变得更混。</div><div style=\"text-align: justify;\">他在这翻来覆去的叫骂，挑拨的余沧海是火气上涌，如果不是刘正风和定逸师太拦着，就要上前把林平之这个小驼子撕成碎片了，可林平之已经把陈昂当作自家报仇唯一的希望，加上他把余沧海恨到了骨子里，嘴上越骂越恶毒，后来干脆忘了挑拨之事，只想把胸中的一口的恶气出出来，想着哪怕被立即杀死也无憾了。</div>', '2018-06-06');
INSERT INTO `chapter` VALUES ('35', '15', '第七章惊艳一镖', '<div style=\"text-align: justify;\">任我行固然失踪已久，但在江湖上威名仍然不减，好多人即使恨他入骨，但提起任我行的武功，依然不得不承认是天下少有的，比起任我行这样的武功绝顶的魔教豪强，江湖人更看不起那些武功不行，张口就是大话的人。求小说网 qiuxiaoshuo.com</div><div style=\"text-align: justify;\">陈昂此言一出，非但没有让他们起了什么同仇敌忾之心，反而多出了几分鄙视。江湖中人，强者为尊，陈昂此时表现，武功远远及不上任我行，却敢口出狂言，心中都瞧他不起，有些人忍不住便露出鄙夷之色，就连定逸师太也觉得陈昂实在太过狂妄。</div><div style=\"text-align: justify;\">只有令狐冲，虽然也觉得陈昂说话是有些不妥，但心里却觉得他志向高远，日后成就未必会输给任我行。</div><div style=\"text-align: justify;\">陈昂此言一出，自然不会和任我行有什么关系了，定逸师太提脚退了一步，示意他继续说，竟然不愿和陈昂这种嚣张之人说话。</div><div style=\"text-align: justify;\">陈昂看向有些失神的令狐冲，忽然开口笑道：“什么任我行的，不说其他，令狐兄出身的华山，便有一门更胜于它的武功，比起武当少林，精深之处，绝不输于，醇和精净尤有过之”</div>', '2018-06-06');
INSERT INTO `chapter` VALUES ('36', '15', '第八章独孤剑术', '<div style=\"text-align: justify;\">下一刻，众人就看见，木高峰嘭的一声，从天上重重摔下来，双手掩住了自己的咽喉，鲜血还不停地自指缝间泌出，一柄暗淡无光的黑色飞镖，静静的插在上面。</div><div style=\"text-align: justify;\">陈昂也看到了他那张已因痛苦而痉挛的脸，失望的叹息一声：“世界那么大，为何不去看看非要来找死呢”</div><div style=\"text-align: justify;\">几步来到他身前，陈昂一寸一寸的将飞镖从木高峰的喉咙里拔出来。</div><div style=\"text-align: justify;\">此时场中，却是人人变色，一片压抑的气息，安静的连一根针落在地上，都清晰可闻。</div><div style=\"text-align: justify;\">塞北明驼虽然称不上什么绝顶高手，但也和嵩山十三太保中比较厉害的几位不相上下，现在却躺在这里，如同一条死狗，真教人难以相信自己的眼睛。</div><div style=\"text-align: justify;\">下方窃窃私语的五岳剑派弟子都安静了下来，像是中了定身的术法，傻愣愣的看着陈昂，好像在看一只怪物。</div><div style=\"text-align: justify;\">定逸师太默然想到：要是余沧海走的晚一些，只怕这地上又要多躺着一个人了</div><div style=\"text-align: justify;\">陈昂，又是陈昂。</div><div style=\"text-align: justify;\">仿佛石头里蹦出的孙猴子。</div>', '2018-06-06');
INSERT INTO `chapter` VALUES ('37', '15', '第九章金盆洗手', '<div style=\"text-align: justify;\">今日是衡山派刘正风大侠“金盆洗手”的正日，衡山城里一片喜气洋洋，五六百位远客流水般涌到，五岳剑派其他几门的同好，江湖上一些颇有名声地位的大豪，甚至是一些不三不四之辈先后到来。</div><div style=\"text-align: justify;\">这些人有的互相熟识，有的只是慕名而从未见过面，一时大厅上招呼引见，喧声大作。五岳剑派的其他掌门，看着往来的人群中，有些鱼目混珠的宵小之辈，不由得大皱眉头，均觉得刘正风不知自重，如此折节下交，堕了五岳剑派的名头。</div><div style=\"text-align: justify;\">这时已到巳时二刻，刘正风便返入内堂，由门下弟子招待客人，他刚坐定，便看到一道黑光一闪即末，抬头看时只见一根黑色的精铁长针，钉在他右手侧。</div>', '2018-06-06');
INSERT INTO `chapter` VALUES ('29', '15', '第一章大脑超频', '<div style=\"text-align: justify;\">陈昂默默的咽下了一片透明的小药片，时间在他眼中忽然变得很慢很慢，周围的一些信息乱糟糟的进入他的脑袋里面，让他感觉十分的嘈杂，脑子里乱哄哄的。但随着药力的发挥，他的眼神很快变得清明。</div><div style=\"text-align: justify;\">急速运转的大脑里，各种信息被分门别类的处理，他所看见，所听见的一切信息，都有条不紊的通过他的大脑处理，其中几条被他专门的挑了出来。</div><div style=\"text-align: justify;\">那是前方五百米左右的地方，一个金发的外国女郎，撑着她疲惫的眼睛和另一位外国男子在说话，他们说话的声音算不上大，所以传到陈昂这里，就只剩下细如蚊呐的一点，但在大脑的解析下，这点声音却异常清晰的出现在他耳边。</div><div style=\"text-align: justify;\">“宝贝别这样”</div><div style=\"text-align: justify;\">“理查德，我得走了”</div><div style=\"text-align: justify;\">两人相互拉扯着，事实上陈昂早都知道他们要说什么，在现在这种状态下，陈昂可以从自己的脑袋里，翻出记忆中任何的细节，哪怕是一部无聊时看过的电影。</div>', '2018-06-06');
INSERT INTO `chapter` VALUES ('30', '15', '第二章超频异能', '<div style=\"text-align: justify;\">“这真是人类进化史上的奇迹，大脑的进一步开发，将让我们成为另一种存在”陈昂看着眼前的紫色药剂，衷心的赞叹道。</div><div style=\"text-align: justify;\">“不像艾迪，露西对大脑的开发是永久性的，但是也因此造成了它致命的副作用，但博士你带回来的二号催化物能对露西产生决定性的影响，我们由此提取出了削弱版的露西，将副作用降低到人体可以承受的水平这是上帝的恩赐”老人碎碎叨叨的表达着自己的激动。</div><div style=\"text-align: justify;\">二号催化物就是陈昂带回来的露西的干细胞，而艾迪代指的是nzt药剂，露西代指着cph4病毒，这些代号都只有陈昂才知道其中的意义。</div><div style=\"text-align: justify;\">“效果如何”陈昂不得不打断这位激动的不能自已的老人。</div><div style=\"text-align: justify;\">老博士深吸一口气，将自己投入到更深一层的超频状态，眼神才恢复了冷静“效果惊人博士实验体保持在了超频状态，甚至可以轻易的进入超频一度状态，只要他集中精神，不需要任何辅助，他就能自主开启超频一度，根据我们的检查，他的大脑开发度已经超过了百分之二十，这一部分是永久的激活状态”</div>', '2018-06-06');
INSERT INTO `chapter` VALUES ('31', '15', '第三章初入笑傲', '<div style=\"text-align: justify;\">陈昂降临世界之后，并不着急往华山方向去，而是一身赤脚医生的打扮，一路上行医治病往衡山方向走，同时尽量和武林中人接触，这两个月下来，治疗的刀伤毒疮数不胜数，不但让他得到了很多内力的样本数据，还在江湖中有了几分名气。</div><div style=\"text-align: justify;\">由于他医术精湛，擅长外科，特别是一个月前，为一位中了蛊毒的孩子剖腹取虫，顿时声名大噪，在江湖中得到了一个赛华佗的诨号。这倒让陈昂有些哭笑不得。</div><div style=\"text-align: justify;\">这一日，陈昂正在为一个练外功的汉子纠正着骨骼的偏差，那人身上虬结成一团的筋骨让他看了大皱眉头：“外功没有正确的练习方法，一时间还看不出什么来，但练习的久了，没有秘诀的人身体就会畸形发育，我得到几份口诀都是这样残缺不全的东西，都缺少了其中核心的吐纳之法。”</div>', '2018-06-06');
INSERT INTO `chapter` VALUES ('32', '15', '第四章青城矮子', '<div style=\"text-align: justify;\">群玉院在衡山城实在是大大有名的地方，就连陈昂来衡山不过两三天，也听过它的名声，正是衡山城里最有名的妓{院是也，田伯光是个采花贼，不但自己常住在妓{院里，就连带令狐冲疗伤的时候，也要往妓{院里去。</div><div style=\"text-align: justify;\">只可怜仪琳一个小尼姑，为了心上人，龙潭虎穴也敢闯，即使脸上红的快要烧掉了，还是艰难的开口请陈昂进去。</div><div style=\"text-align: justify;\">陈昂推开门，就见到一个长方脸蛋，剑眉薄唇的青年，半躺在床上，胸口的创口被布条裹着，隐隐有些药味，在陈昂看来那创口极深，再有三寸就危及心脏了。</div><div style=\"text-align: justify;\">那青年笑的不羁，看见仪琳便打趣道：“你要请个大夫来，还不如给我带壶酒，我这人一碰上好酒，什么伤痛都没有了”</div><div style=\"text-align: justify;\">“这个法子不妨试试”陈昂笑道，抬手银针闪动，眨眼间就有五根封住了他胸口的大穴，银针起落间，交错的犹如银网，不过一会的功夫，就扎满了令狐冲全身上下。</div><div style=\"text-align: justify;\">细小的银针封住血脉凝涩之处，伤口就不在隐隐发痛了。</div>', '2018-06-06');
INSERT INTO `chapter` VALUES ('33', '15', '第五章一点寒芒破青城', '<div style=\"text-align: justify;\">余沧海拿出这等看家本领，已是怒极，摧心掌法在他手里施展开来，身前一丈之内，都在掌风的笼罩之下，单论掌法中的阴狠毒辣，放眼武林，也难有出其右者。</div><div style=\"text-align: justify;\">“好掌法”陈昂赞叹道：“可这并没有什么卵用”</div><div style=\"text-align: justify;\">右掌后撑，左掌前伸，两手的小拇指和无名指同时夹住三支飞镖，最有力的食指和中指却捏着一根银钉，离他最近的令狐冲，也只能看到他的双手幻化出的道道残影，反掌间闪动的六点银光。</div><div style=\"text-align: justify;\">就这六点银芒，却在瞬息间闪没，只往余沧海的要害大穴上招呼。</div><div style=\"text-align: justify;\">六把燕尾镖，都是极为坚韧的钛合金所制，在高速运动中，经过大型计算机模拟的气动力外形，赋予它无比的平衡力，在陈昂精妙的手法下，就是一块石头，也能扎透，而且另有妙用。</div><div style=\"text-align: justify;\">余沧海当然不敢硬接，只听耳边飞镖摩擦的微微的风响，他就明白，硬接绝对是找死的行为。</div>', '2018-06-06');
INSERT INTO `chapter` VALUES ('9', '4', '第1章 我家大门穿越了', '“王旭，你要的东西到了。”<br/>　　伴随着滚滚黑烟，一辆改装过的农用三轮车，吭吭哧哧的爬上半山腰，停在了一个山中小屋门口。<br/>　　没一会的功夫，小屋中走出来一位年轻人，他看上去二十来岁，脸上带着微笑，细看却有点凶恶。<br/>　　这种凶，不是长得不好，相反，此人的样子还有点小帅。只是眉目之间，给人的感觉有点凌厉，有种在电视上，看到反派演员的既视感。<br/>　　“王旭，你真打算好了，就待在老家，跟这几亩果树打交道，不学学别人，去城里发展一下？”看到年轻人出来，开着三轮的汉子，主动走过去打了个招呼。<br/>　　王旭递上两根烟，等二人都点上了，才深深吸两口，吐出一股云雾，摇头道：“周哥，我高中都没毕业，去城市也就是端盘子，扫地，听人使唤的命，还不如待在老家，守着几亩果园来的潇洒。”<br/>　　“这几年，可没听说，有人靠果园子发财的，果园子现在不好弄啊！”周哥说的不客气，脸上的神色却很专注，并不是在挖苦什么。<br/>　　王旭也知道这一点，周哥叫周强，没什么大本事，但是在十里八村很有人缘。<br/>　　年轻的叫他周哥，年纪大的叫他强子，这人是公认的好人，平日里在城里面卖菜，没少给村里人帮着捎带东西，是个热心肠。<br/>　　王旭这次打算弄个防盗门，放在山上果树园的小屋里，周强听到后就自告奋勇的帮忙，省了一百多的运费不说，连饭都不吃他一口，这个人情王旭记得。<br/>　　“周哥，我这人没什么本事，有口饭吃就知足了，太远的地方我想不到，也不敢想啊！”王旭笑着开口，语气中不无自嘲。<br/>　　周强叹了口气，没有再说什么，拍了拍王旭的肩膀，说声好好干就走了。<br/>　　王旭一路目送，直到周强开着三轮车，在视线中再也看不到，才稍微显得有些没落，自语道：“我也想出人头地，我也想风风光光，可我一没学历，二没本事，就是长得凶了点，难道要我去拍电影啊？”<br/>　　拍电影这个想法更不靠谱，比他当果农发家难多了，横店可不缺特效演员，缺的只是有没有关系。<br/>　　王旭祖上八辈都是贫农，别说贿赂导演，就是自费去横店的钱，他现在都拿不出来。<br/>　　摇摇头，王旭抱起地上的防盗门，头也不回的向着屋里走去，临进门的时候看了眼天空，低语道：“好像要下雨了...”<br/>　　...咔嚓...<br/>　　八月的天气，就像小孩子的脸一样，说变就变。<br/>　　狂风肆意，暴雨来临，整个转变不过半个小时的功夫。<br/>　　王旭在山上的小屋，是上一位包山的果农留下的，窗户已经被熊孩子打坏，门也不知所踪。<br/>　　风雨一来，豆大的雨点借着风势，愣头愣脑的往屋里冲。<br/>', '2018-04-05');
INSERT INTO `chapter` VALUES ('10', '6', '第一章 天黑别出门', '<p>　　天黑，别出门。<p>　　这句话在残老村流传了很多年，具体是从什么时候传下来的，已经无从考证。不过这句话却是真理，无需怀疑。<p>　　残老村的司婆婆看到夕阳一点点藏在山后，心里又紧张起来。随着夕阳落下，最后一缕阳光消失，天地间突然一下子寂静无比，没有任何声音。只见黑暗从西方缓缓的淹没过来，沿途吞噬山川河流道路树木，然后来到残老村，将残老村淹没。<p>　　残老村的四个角竖着四个古老石像，石像斑驳，年代久远，即便是司婆婆也不知道这石像是何人雕琢，何时竖在这里。<p>　　黑暗降临，四个石像在黑暗中散发出幽幽的光芒，石像依旧亮着，让司婆婆和村里的老者都松了口气。<p>　　村外的黑暗越发浓郁，但有了石像的光，残老村便还算是安全的。<p>　　突然，司婆婆耳朵动了动，呆了呆，失声道：“你们听，外面有个孩子的哭声！”<p>　　旁边的马老摇头道：“不可能，你听错了……咦，真有婴儿的哭声！”<p>　　村外的黑暗中传来婴儿的哭声，村里其他老人除了耳聋的都听到了这个哭声，老人们面面相觑，残老村偏僻荒凉，怎么会有婴儿出现在附近？<p>　　“我去看看！”<p>　　司婆婆激动起来，踮着小脚跑到村子的一个石像边，马老连忙过去：“司老太婆，你疯了？天黑了，出了村就是死！”<p>　　“背着这个石像出村，黑暗里的东西怕石像，我一会半会死不了！”<p>　　司婆婆弯腰，想要将石像背起，不过她是个驼背，背不起来。马老摇了摇头：“还是我来吧。我背着石像陪你去！”<p>　　一旁又有一个老者一瘸一拐的走过来，道：“马爷，你只有一条胳膊，背石像撑不了多久，我两手齐全，还是我来背。”<p>　　马老瞪他一眼：“死瘸子，你断了条腿，能走吗？我虽然只有一条胳膊，但这条胳膊力气大得很！”<p>　　他独臂将石像抱起，稳了稳步子，石像难以想象的沉重：“司老太婆，咱们走！”<p>　　“别叫我死老太婆！瘸子，哑巴，你们大家都要当心些，村里少了一个石像，千万不要被黑暗里的东西摸进来！”<p>　　……<p>　　马老和司婆婆走出残老村，黑暗中不知有什么古怪的东西围绕两人游走，但被石像的光芒一照，便吱吱怪叫退回黑暗之中。<p>　　两人循着那哭声前进，走出百十步，来到一条大江边，那婴儿的哭声就是从江边传来。石像散发出幽幽的光芒，照不太远，两人细细捕捉声音方位，沿着这条江向上游走去，走出几十步，哭声就在附近，马老独臂已经很难支撑。司婆婆眼睛一亮，看到一丁点荧光，那是一个篮子停在江岸边，荧光从篮子里传来，哭声也是从篮子里传来。<p>　　“真有一个孩子！”<p>　　司婆婆上前，提起篮子，却微微一怔，没能提起来，那篮子下面是一条被江水泡得发白的手臂，正是这条手臂将篮子和篮子里的孩子托起，一直托到岸边。<p>　　“放心吧，孩子安全了。”司婆婆对水下的那个女子低声说。<p>', '2018-05-29');
INSERT INTO `chapter` VALUES ('11', '6', '第二章 四灵血', '<div style=\"text-align: justify;\"><div>司婆婆拉着他兴冲冲的往村里走，笑道：“别看了，快点过来，今天是你的大日子！村长，马爷，都出来！”</div><div><br></div><div>&nbsp; &nbsp; 村里燃起了篝火，村长又被人用担架抬了出来，沉声道：“四灵都找到了？”</div><div><br></div><div>&nbsp; &nbsp; “都找到了。”</div><div><br></div><div>&nbsp; &nbsp; 独臂的马爷拖来了一条几丈长的大蛇，碧青色，也还活着，泛着腥气，只是被马爷单捏住七寸，动弹不得。</div><div><br></div><div>&nbsp; &nbsp; 哑巴铁匠则提来了一头大鸟，那头大鸟比哑巴还要高大一些，但是被绑住了翅膀和双脚。那大鸟挣扎时，羽毛中竟然有火光飞出，噼里啪啦作响，很是吓人。</div><div><br></div><div>&nbsp; &nbsp; 瞎子则搬来了一只比桌子面还要大的巨龟，这头巨龟不知活了多少年，龟壳都翻起了金黄色。巨龟四肢都缩在壳里，时不时偷偷的探出一只爪子，秦牧看到它的爪子探出壳，爪子下便生出水汽，似乎能够将这头金龟托起，驾着水汽逃之夭夭。</div><div><br></div><div>&nbsp; &nbsp; 只是金龟被瞎子用鱼钩穿住鼻孔，无法逃走。</div><div><br></div><div>&nbsp; &nbsp; “青龙，白虎，朱雀，玄武，这四灵的血虽然无法弄到，不过用青蛟蛇、铁骨虎、雷鸟和金龟代替，也可以炼出一点灵血来，足够用了。”</div><div><br></div><div>&nbsp; &nbsp; 村长向村里的屠户点了点头，屠户咧嘴笑了笑，双撑地上前，他是个只剩下上半身的汉子，腰部以下被人砍断，伤口平整。</div><div><br></div><div>&nbsp; &nbsp; 四口缸放在青蛇老虎雷鸟和金龟前，屠户一刀一只，给这些猛兽放血，过了不久，四个猎物鲜血流尽。</div></div>\r\n', '2018-05-29');
INSERT INTO `chapter` VALUES ('15', '6', '第三章 神通', '<div style=\"text-align: justify;\">药师有了自己的想法，道：“给他喝灵血，多多的喝，死命的喝！灵血每次都能多少提升一点他的体质，喝得多了，虽然激发不了灵体，但那身体素质一定比什么灵体都厉害！”</div><div style=\"text-align: justify;\"><br></div><div style=\"text-align: justify;\">&nbsp; &nbsp; “一拳打死一条龙。”</div><div style=\"text-align: justify;\"><br></div><div style=\"text-align: justify;\">&nbsp; &nbsp; 村长笑道：“一定能够吓死大墟外面的那些王八蛋。”</div><div style=\"text-align: justify;\"><br></div><div style=\"text-align: justify;\">&nbsp; &nbsp; 两人相视一笑，药师走出房间，掩上房门。</div><div style=\"text-align: justify;\"><br></div><div style=\"text-align: justify;\">&nbsp; &nbsp; 第二天，村民们又弄来几只铁骨虎、青蛟蛇、雷鸟和金龟，这些老头子老太太有了目标，干劲十足，不过惹得药师发怒了：“让他一次喝太多灵血，会把他撑死的！”</div><div style=\"text-align: justify;\"><br></div>', '2018-05-30');
INSERT INTO `chapter` VALUES ('16', '6', '第四章 天魔造化功', '<div style=\"text-align: justify;\">瘸爷爷的腿功这么快，能够跑上天空，那么是谁砍断了他的腿？马爷爷的拳这么厉害，又是谁砍断了他的右臂？还有屠爷爷的刀，谁能够突破屠爷爷的刀，将他拦腰砍断？”</div><div style=\"text-align: justify;\"><br></div><div style=\"text-align: justify;\">&nbsp; &nbsp; 秦牧见到屠夫、马爷和瘸子的真本事，既是佩服又是不解，他跟随瘸子学完腿功，总算将四灵血的力量消化，体质有所提升，只是这次将他累得半死，恨不得直接倒下来呼呼大睡。</div><div style=\"text-align: justify;\"><br></div><div style=\"text-align: justify;\">&nbsp; &nbsp; 然而，这只是他苦难的开始。</div><div style=\"text-align: justify;\"><br></div><div style=\"text-align: justify;\">&nbsp; &nbsp; 几乎每一天，村里的老头老太太都会捉来几只猛兽炼成四灵血，给他灌下去。灌下去之后便是疯狂的训练，直到将他折腾得筋疲力尽这才罢休。</div><div style=\"text-align: justify;\"><br></div><div style=\"text-align: justify;\">&nbsp; &nbsp; 除了瘸子的腿功，独臂马爷的拳，屠夫的刀，他还需要跟随哑巴学习打铁，跟聋子学习书画，跟瞎子学听风辨位，蒙上双眼与瞎子比棍法。</div><div style=\"text-align: justify;\"><br></div><div style=\"text-align: justify;\">&nbsp; &nbsp; 累得实在不行的时候，又会被村长叫去，一起呼吸吐纳，村长说传授给他的呼吸吐纳法门是专门训练霸体的功法，叫做霸体三丹功，很是厉害。</div>', '2018-05-30');
INSERT INTO `chapter` VALUES ('17', '6', '谢谢大家的打赏！', '<div style=\"text-align: justify;\">宅猪新书上传第二天，才刚刚四章，就有这么多读者打赏，心中既是高兴又是愧疚。</div><div style=\"text-align: justify;\"><br></div><div style=\"text-align: justify;\">&nbsp; &nbsp; 深呼吸uc，洛川幽冥，牧神记，玉小清，穿窗，叁生缘楚天帝，超级无敌帅168，古道黯然，苦战天，无极限网络，天尊白狐，zuizhe8888，缘夙之，存在感太低，濯妖，君子承诺的永恒，香水印记，推倒是幸福，野人9，shindao，中国创造016……</div><div style=\"text-align: justify;\"><br></div><div style=\"text-align: justify;\">&nbsp; &nbsp; 这里面有熟悉的名字也有新面孔，五百多位读者的打赏，无法一一细表，无法一一感谢，深呼吸uc盟主的百万飘红着实把宅猪吓到了，也带来了更多的读者，相当于一个大推荐，牧神记的收藏也因此飙增，谢谢！</div>', '2018-05-30');
INSERT INTO `chapter` VALUES ('18', '6', '第五章 漓江五老', '<div style=\"text-align: justify;\">这个声音突然传来，中气十足，明明是从远处传来，但却仿佛在他们耳边响起一般，震得已经变成麋鹿的秦牧耳朵嗡嗡作响。</div><div style=\"text-align: justify;\"><br></div><div style=\"text-align: justify;\">&nbsp; &nbsp; 他循声看去，远处的悬崖上站着几个人影，从山麓到悬崖，约有六七里地的路程，秦牧已经看不太清面孔，但能够将声音传得这么远，还如此清晰，应该不是普通人。</div><div style=\"text-align: justify;\"><br></div><div style=\"text-align: justify;\">&nbsp; &nbsp; 司婆婆挎着篮子，笑道：“天魔？什么天魔？老身只不过是江边的普通人，这小鹿也是寻常的鹿，是老身养大的……”</div><div style=\"text-align: justify;\"><br></div><div style=\"text-align: justify;\">&nbsp; &nbsp; “牧儿，跑！”</div><div style=\"text-align: justify;\"><br></div><div style=\"text-align: justify;\">&nbsp; &nbsp; 秦牧听到司婆婆的声音，心中一怔，想要说话却说不出声。他不想走，担心司婆婆遇到危险。</div><div style=\"text-align: justify;\"><br></div><div style=\"text-align: justify;\">&nbsp; &nbsp; “江边的普通人？中气这么足，能将声音清晰的传到我们耳中，普通的老太婆是做不到的。”</div><div style=\"text-align: justify;\"><br></div><div style=\"text-align: justify;\">&nbsp; &nbsp; 那山崖上，一个年老却又洪亮的声音冷笑道：“而且，天魔造化功我漓江五老是断然不会认错的。剥皮制衣，千变万化，这么歹毒的法都被我们看在眼里，你还想狡辩？”</div>', '2018-05-30');
INSERT INTO `chapter` VALUES ('19', '6', '第六章 小不点儿，死', '<div style=\"text-align: justify;\">“难道她是用这道细线操控这口剑？只是这么细的线，她是如何做到让剑转向的？”</div><div style=\"text-align: justify;\"><br></div><div style=\"text-align: justify;\">&nbsp; &nbsp; 秦牧来不及想出其中的奥妙，立刻飞奔而去，只听咄的一声，那口剑与他擦身而过，刺入一株大树之中，深入树身。</div><div style=\"text-align: justify;\"><br></div><div style=\"text-align: justify;\">&nbsp; &nbsp; 那口剑仿佛活物般，在树身中跳动两下，没能从树身中拔出，随即那女子飘然而至，纤细掌握住剑柄，将宝剑从树身中抽出，懊恼道：“我的白虎真元还是不够强，无法做到如臂使指……”</div><div style=\"text-align: justify;\"><br></div><div style=\"text-align: justify;\">&nbsp; &nbsp; “晴师妹，你能够以真元化作细丝，御剑杀敌，已经很了不起了&lt;b&gt;www.shukeba.com&lt;/b&gt;。”</div><div style=\"text-align: justify;\"><br></div><div style=\"text-align: justify;\">&nbsp; &nbsp; 与她一起踏波而行的那个男子来到她身边，柔声笑道：“你欠缺的并非是修为，而是火候，这次师父带着我们来到大墟历练，便是让我们补上这个弱点。以往我们自顾自修炼，缺乏实战，而现在这个小魔崽子就是我们的实战会，你很快便可以掌握以气御剑。”</div><div style=\"text-align: justify;\"><br></div><div style=\"text-align: justify;\">&nbsp; &nbsp; 另外三个少年赶至，其中一位少年笑道：“这小魔崽子变化成鹿，鹿本来便十分敏捷，所以能够躲过师姐的御剑。”</div><div style=\"text-align: justify;\"><br></div><div style=\"text-align: justify;\">&nbsp; &nbsp; 那位晴师姐精神大震，继续御剑向秦牧刺去，娇笑道：“曲师兄，你先不要出，留下这小魔崽子给师妹练练剑。”</div>', '2018-05-30');
INSERT INTO `chapter` VALUES ('20', '1', '第五章 花开', '<div style=\"text-align: justify;\">山顶附近陷入寂静，没有了声音。</div><div style=\"text-align: justify;\">　　三头生物没有理会楚风，像是将他忽略了。</div><div style=\"text-align: justify;\">　　楚风明白，他现在离山顶较远，而且它们可能觉得他不具备威胁，所以并不在意，任他站在下方。</div><div style=\"text-align: justify;\">　　这是三头有灵性的非凡生物。</div><div style=\"text-align: justify;\">　　“趁现在离开！”</div><div style=\"text-align: justify;\">　　楚风决定下山，虽然他对那株扎根在青铜山上的小树非常好奇，渴望了解，但是这里对于他来说太危险，随时会丢掉性命。</div><div style=\"text-align: justify;\">　　香气变浓郁了，从青铜山上传来。</div><div style=\"text-align: justify;\">　　那头獒动了，快如闪电，几个起落间，便穿过乱石堆，而后沿着那陡峭的山体，径直冲上了山巅。</div><div style=\"text-align: justify;\">　　一丈多长的黑色牦牛，周身乌黑光亮，头上粗大的犄角很慑人，它迈开蹄子，不紧不慢的跟在后方。</div><div style=\"text-align: justify;\">　　它走的很稳，沿着有土石的那一侧，居然也登上了险峻的青铜山。</div><div style=\"text-align: justify;\">　　半空中的那头凶禽跟黄金浇铸似的，羽翼越发璀璨，瞳孔闪动金光，它降低高度，临近山崖，注视着小树。</div><div style=\"text-align: justify;\">　　在楚风准备退走时，那股香气浓郁了数倍不止，花蕾即将绽放。</div><div style=\"text-align: justify;\">　　“啵！”</div><div style=\"text-align: justify;\">　　虽然隔着有段距离呢，但是楚风清晰的听到花开的声音，小树顶端那拳头大的银白花骨朵绽放了一瓣。</div>', '2018-05-30');
INSERT INTO `chapter` VALUES ('21', '1', '第六章 石盒', '<div style=\"text-align: justify;\">　 &nbsp; &nbsp;夜晚，帐篷中原本很静，突兀的声响划破安宁，楚风的手僵在那里，停止了所有动作。</div><div style=\"text-align: justify;\">　　正方体石块怎么会发出这种声音？</div><div style=\"text-align: justify;\">　　一道缝隙出现在石块上。</div><div style=\"text-align: justify;\">　　楚风放下它，怕有什么变故出现，仔细观察，今日经历过一些异事，他格外谨慎。</div><div style=\"text-align: justify;\">　　“石盒？！”他惊讶。</div><div style=\"text-align: justify;\">　　环绕石块的那些纹络，曾遮掩住这道缝隙，现在略微开启后，这才清晰显现出来。</div><div style=\"text-align: justify;\">　　早先，石盒太严丝合缝，浑若一体，再加上有斑痕覆盖，很难被发现有异。</div><div style=\"text-align: justify;\">　　谁会留意这竟是一个正方体的石盒？三寸高，很古朴。</div><div style=\"text-align: justify;\">　　事已至此，楚风有些期待，因为石盒有些神秘，在昆仑山山脚下捡到，原本只当它是石块，谁曾想竟另有乾坤。</div><div style=\"text-align: justify;\">　　楚风将帐篷中的铜盆挡在身前，进行防御，而后小心的开启石盒，让那缝隙变大。</div><div style=\"text-align: justify;\">　　“喀！”</div><div style=\"text-align: justify;\">　　盒盖脱离，并没有什么异常，无危险发生。</div><div style=\"text-align: justify;\">　　楚风放下心，打量石盒内部。</div><div style=\"text-align: justify;\">　　他略有希冀，究竟有什么密封在当中？</div><div style=\"text-align: justify;\">　　石盒内部空间很小，只有一个很浅的凹槽，几乎装不下什么东西，显然不可能藏着明珠美玉等。</div><div style=\"text-align: justify;\">　　不过，当中的确有物。</div><div style=\"text-align: justify;\">　　在那凹槽内，有三颗干瘪的种子，彻底将那里填满，除此之外，再无其他。</div>', '2018-05-30');
INSERT INTO `chapter` VALUES ('24', '14', '第一节 林家大少', '<div style=\"text-align: justify;\">要问福州城内哪家镖局最大，当属福威镖局。福威镖局镖头众多，镖局龙头林震南颇善经营，且为人疏阔，黑白两道都要卖他个面子。这两年生意越的大，周围数省的走镖买卖，福威镖局都掺了一手。</div><div style=\"text-align: justify;\">按说镖局兴盛，家中又有一个贤惠妻，该是美满的事情。但林震南却并不怎么顺心。这全都因为他的大儿子。三年前其妻子怀孕，生下一对双胞胎。</div><div style=\"text-align: justify;\">虽然是双胞胎，却长得不一样，这并不是什么多奇怪的事情。</div><div style=\"text-align: justify;\">小儿林平之乖巧聪明，三岁的小孩长得粉雕玉琢，像个玉童子。真是捧在手里怕碎了，含在嘴里怕化了，看在眼里怕丢了，宝贝的不得了。</div><div style=\"text-align: justify;\">问题出在他的大儿子身上。从生下来之后，大儿子林阳就格外的安静，只有到饿了和排泄的时候才会哭两声。其他时间不是闭着眼睛睡觉，就是睁着眼睛呆。</div>', '2018-05-31');
INSERT INTO `chapter` VALUES ('25', '14', '第二节 破界珠', '<div style=\"text-align: justify;\">第二天一早，苏重准时醒来。这不是他不想睡懒觉，而是到了时间他就会自己醒过来，这不是他能控制的。即使想要躺在床上继续睡，但精神旺盛却怎么也睡不着。</div><div style=\"text-align: justify;\">苏重不以为意，三年时间他造就习惯。每天作息规律，天睡人睡，天醒人醒。这全都是他脑中的破界珠造成的。正是由于破界珠，他才会穿越到这个世界。</div><div style=\"text-align: justify;\">前世他就是一个上班族，每天拼死拼活。为了自认为的美好生活，不停的打拼。可一朝醒来，却现自己已经成了另一个人。而且来到了熟悉的笑傲江湖世界。此时想来，过去那些攀比争胜之心实在可笑。一死之后，什么都没了。父母都来不及照顾。只剩无穷无奈。</div><div style=\"text-align: justify;\">他不知道自己怎么来的，但却知道和脑中的破界珠有关。他能够清晰的感觉到那颗珠子的存在，但却从来没见过。这珠子来历神秘，如果不是他穿越异界。他上辈子到死，估计也不会知道自己脑袋里会有一枚珠子。</div>', '2018-05-31');
INSERT INTO `chapter` VALUES ('26', '14', '第三节 基础拳法', '<div style=\"text-align: justify;\">萧胜的父亲是福威镖局的老镖师，不过运气不好，走镖遇到了盗匪。被砍了一刀，流血不止而死。他从小便入了镖局，现在父亲出了事。福威镖局自然有相应的抚恤。但抚恤只是一时，更重要的是，镖局给他一个留在镖局的身份。</div><div style=\"text-align: justify;\">如果没有意外，他便要从底层杂役开始做起。一点点的练武、走镖，积累资历。慢慢上升到趟子手、镖师，最后有可能成为镖头。但如果没有家传武艺，或者师傅知道武艺。想要混成镖头，千难万难。</div><div style=\"text-align: justify;\">他的父亲熬了半辈子，才成为镖师。现在没了他父亲指导武艺，虽然镖局里有几分人情。但人走茶凉，也没多大帮助。他一切都要从头作起。他和其父亲一样，没多少心眼。但却格外的直，也就是一根筋。因此他练武格外的认真刻苦。</div>', '2018-05-31');
INSERT INTO `chapter` VALUES ('27', '14', '第四节 实验', '<div style=\"text-align: justify;\">第二天一早，苏重吃过早饭之后。林氏查看了昨日的功课，见兄弟两人都已经将三个字认清，也能够歪歪扭扭的写出来。便又叫了三个字，嘱咐两人多多练习。不然只会看、不会写，以后一样要闹笑话。</div><div style=\"text-align: justify;\">苏重早就把字认了个全，但却不能说。不过他也不排斥练字，他以前没学过毛笔字。现在写出来，如三岁小儿，和林平之一个水平。这反而不用他去刻意隐瞒。也就老老实实的练了一个时辰的字。</div><div style=\"text-align: justify;\">之后林平之便在丫鬟看护下跑的没影。苏重却抱着一个小凳子走向校场。</div><div style=\"text-align: justify;\">来到校场，找角落处一颗大树下。放下凳子，苏重坐上去，就开始盯着不远处的萧胜练拳。</div><div style=\"text-align: justify;\">萧胜昨夜按照苏重指点，洗了个热水澡之后，用药酒把全身揉搓一边，直到肤色泛红方止。早晨起来，仍然感觉身体有些酸疼。心里庆幸，如果没用药酒活血，今天肯定下不了床。而对于指点他的苏重，越觉得高深莫测起来。</div>', '2018-05-31');
INSERT INTO `chapter` VALUES ('28', '14', '第五节 拜师', '<div style=\"text-align: justify;\">萧胜刚换了一身干净衣裳回到苏重身边。白二就领着他各个找到萧胜。</div><div style=\"text-align: justify;\">“萧胜，你不跟着我混就罢了。但你不能骂我哥，我哥天纵之才，岂是你这个蠢材能比的。”白二得意洋洋。</div><div style=\"text-align: justify;\">苏重静静地看着白二，这家伙明显搬弄是非。</div><div style=\"text-align: justify;\">萧胜气的脸通红，却说不出话。苏重心里暗自摇头，不是怪萧胜口拙，而是怪他看不明白。不管阴谋阳谋，这个江湖最终讲的还是拳头。别人都找上门了，打就是了。</div><div style=\"text-align: justify;\">“萧胜，我兄弟说的话可是真的”白大一脸阴沉，他天赋不差，又有人指点，加上他练武刻苦。福威镖局的同龄人之中，就他武艺最高。听闻有人诋毁他，自然要来教训教训对方。</div>', '2018-05-31');
INSERT INTO `chapter` VALUES ('38', '16', '第一章 三河帮', '<div style=\"text-align: justify;\">“本帮创立由来二十二年，依定例每隔两年招收一批新丁入帮，你们这一批拢共三百八十人，不是孤儿就是草民，贱命一条，嘿嘿！若非本帮愿意收容你们，将来的下场，不是饿死道旁，沦落为孤魂野鬼就是被豪强奴役，贱如草芥，死了也没人埋。”</div><div style=\"text-align: justify;\">定州，阳虞郡，三河帮大校场上。</div><div style=\"text-align: justify;\">一身材高大，皮肤黝黑的中年汉子站在日头底下，呲着牙大声训话。 【】</div><div style=\"text-align: justify;\">此人手臂粗壮，袖管底下肌肉虬结，高高鼓胀，其手掌宽大有力，巴掌好似蒲团大小，烈日暴晒下，他身子挺直如标枪，予人一种巨大的压迫感。</div><div style=\"text-align: justify;\">在他的下首，一队队新丁整齐排列，目光不敢直视，各个面色凛然。</div><div style=\"text-align: justify;\">黝黑汉子眼珠子转动，默默观察着一众新丁的神色变化，话锋一转：“不过，你们也别高兴得太早，现在你们还远远算不上本帮正式弟子，甚至连外围成员都不算，想要入帮？那么，就先站三个时辰再说吧！”</div>', '2018-06-06');
INSERT INTO `chapter` VALUES ('39', '16', '第二章 穿界青铜门', '<div style=\"text-align: justify;\">“本帮创立由来二十二年，依定例每隔两年招收一批新丁入帮，你们这一批拢共三百八十人，不是孤儿就是草民，贱命一条，嘿嘿！若非本帮愿意收容你们，将来的下场，不是饿死道旁，沦落为孤魂野鬼就是被豪强奴役，贱如草芥，死了也没人埋。”</div><div style=\"text-align: justify;\">定州，阳虞郡，三河帮大校场上。</div><div style=\"text-align: justify;\">一身材高大，皮肤黝黑的中年汉子站在日头底下，呲着牙大声训话。</div><div style=\"text-align: justify;\">此人手臂粗壮，袖管底下肌肉虬结，高高鼓胀，其手掌宽大有力，巴掌好似蒲团大小，烈日暴晒下，他身子挺直如标枪，予人一种巨大的压迫感。</div><div style=\"text-align: justify;\">在他的下首，一队队新丁整齐排列，目光不敢直视，各个面色凛然。</div><div style=\"text-align: justify;\">黝黑汉子眼珠子转动，默默观察着一众新丁的神色变化，话锋一转：“不过，你们也别高兴得太早，现在你们还远远算不上本帮正式弟子，甚至连外围成员都不算，想要入帮？那么，就先站三个时辰再说吧！”</div>', '2018-06-06');
INSERT INTO `chapter` VALUES ('40', '16', '第三章 一夜之间气感生，果是武学奇才', '<div style=\"text-align: justify;\"><div>肉！吃到嘴里，满嘴流油，吞下肚里，酣畅淋漓，王动从来没有想到过，自己有一天光是吃肉就觉得如此感动，不过他的吃相还算好的，其他人的吃相才真是不敢恭维，一阵阵狼吞虎咽，几如疯狗抢食一般。 【】</div><div>这也是没办法，这个世道，朱门酒肉臭，路有冻死骨，肉食者高高在上，贫苦人家却一年到头也未必能吃上几顿肉，就算有的吃，也没办法做到如三河帮这般量大管饱。</div><div>吃！卯足了劲的吃，很快王动也抛开了所谓吃相，拼命抢食，只有吃肉才能长力气，有了营养，才能养好身体，变得强壮。</div><div>而便在一众少年围着五六大盆荤菜大嚼大咽之际，在旁边还负手站着一中年人，是与那送饭菜的杂役一起来的，他一边笑眯眯的看着，一边大谈特谈加入三河帮的好处，总之是大鱼大肉算什么，只要将来对帮派有了贡献，大富大贵，白花花的银子，水灵灵的女人，那是唾手可得。</div></div>', '2018-06-06');
INSERT INTO `chapter` VALUES ('41', '17', '第1章惨痛的车祸', '<div style=\"text-align: justify;\">2003年6月10日，一场突来的暴风雨，席卷了整个神州大地，为刚刚结束的高考带去了降温。</div><div style=\"text-align: justify;\">　　海城只是众多大城市之中的一个三流小城市，暴风雨过后，路面上到处都是坑坑洼洼的积水，零散的人群在来来回回的穿梭，偶尔有一辆黑色的壳子从身边经过，溅起无数的积水，引来路人的谩骂。</div><div style=\"text-align: justify;\">　　一个十八九岁的少年骑着一辆崭新的山地车显得格外的养眼，因为他的速度很快，快到根本就不管路边的积水，车上、身上已经溅满了泥点，可是他依然不顾，脸上好像带着很着急的样子。</div><div style=\"text-align: justify;\">　　“快点，快点，一定要快点，千万不要出事，千万不要出事……”</div><div style=\"text-align: justify;\">　　少年名为唐枫，是海城第一高级中学的一名高三学生，今年刚刚参加完高考，此时的他汗水已经浸湿了全身，嘴里喘着粗气，依然没有能够阻止他骑车的速度。</div>', '2018-06-06');
INSERT INTO `chapter` VALUES ('42', '1', '第七章 异变', '<div style=\"text-align: justify;\">胖子很能说，一路上嘴巴就没停过，谈他当年在西部上学时听到的异事、奇闻，都带着十分明显的神秘色彩。</div><div style=\"text-align: justify;\">　　藏地多传说，有些故事在当地流传很广，一些记载都可查到源头，确实引人胜胜，相邻座位的人都听的很入迷。</div><div style=\"text-align: justify;\">　　“你们可别当成神话听，有些曾真实发生过。”胖子很认真地说道。</div><div style=\"text-align: justify;\">　　听他吊胃口，有人催促他快讲。</div><div style=\"text-align: justify;\">　　“我曾在一座破庙中看到一头小藏獒守着一只垂死的老狗呜咽，那小狗崽的双眼居然流淌金色的眼泪。”周全说道。</div><div style=\"text-align: justify;\">　　“嘘！”</div><div style=\"text-align: justify;\">　　一群人发出嘘声，都不相信，这也太能扯了，根本就不现实。</div><div style=\"text-align: justify;\">　　“千真万确，我亲身经历的。”周胖子急眼，拍胸脯发誓所言没有虚假。</div><div style=\"text-align: justify;\">　　“我事后回想，可能是它那金色的瞳孔太璀璨了，映照的眼泪都成为了金色。”胖子解释。</div>', '2018-06-06');
INSERT INTO `chapter` VALUES ('43', '1', '第八章 世界变了', '<div style=\"text-align: justify;\">林诺依当日说的话竟然成真，连路边的一株杂草都结出了鲜红的果实，馥郁芬芳，不再平凡。</div><div style=\"text-align: justify;\">　　楚风心中无法平静，思绪起伏！</div><div style=\"text-align: justify;\">　　这个世界不同了，不可理解！</div><div style=\"text-align: justify;\">　　楚风心有悸动，这样的变化让人不安，一切都超出了理解，各种异变正在发生。</div><div style=\"text-align: justify;\">　　“这东西能吃吗？”</div><div style=\"text-align: justify;\">　　不得不说，周全的心真的很大，闻着浓郁的果香，他恨不得咬上一口，到现在竟然还有这种心情。</div><div style=\"text-align: justify;\">　　“你试试看。”</div><div style=\"text-align: justify;\">　　“不行，我可不敢，谁知道有没有毒，一株杂草结出红彤彤的果实，这真跟见鬼了似的！”周胖子摇头。</div><div style=\"text-align: justify;\">　　可他却咽了一口口水，因为这绿油油的野草上长出的果实太诱人了，果香扑鼻，远比平日所见到任何水果都要香浓。</div><div style=\"text-align: justify;\">　　就是楚风都深感意外，这果实带着晶莹的光泽，如同红玛瑙般，一看就非常可口，怎么会是一株普通的草长出的？</div>', '2018-06-06');
INSERT INTO `chapter` VALUES ('44', '1', '第九章 惊悚', '<div style=\"text-align: justify;\">虽然接近黎明，但天色依旧发黑，尤其是罕见的大雾弥漫，覆盖山林，白茫茫，什么都看不到。</div><div style=\"text-align: justify;\">　　这本就是一种令人紧张的气氛，那个年轻人突然一声大叫，在这个时刻直接让人们绷紧的神经有些承受不住了。</div><div style=\"text-align: justify;\">　　“啊……”</div><div style=\"text-align: justify;\">　　一同来到车厢外的几人，其中两个被吓得倒退，差点坐在地上，忍不住跟着大叫出声，带着恐惧。</div><div style=\"text-align: justify;\">　　“你鬼叫什么，想吓死人吗？！”周全怒视，他也被吓的不轻，脖子上的寒毛都炸立了。</div><div style=\"text-align: justify;\">　　“你看到了什么？”楚风问道，他与周全走在一起，离那几人还有一小段距离，大雾弥漫，数米外就看不见人。</div><div style=\"text-align: justify;\">　　“咯咯……咯咯……”那人的牙齿在打颤，吓到嘴唇哆嗦，指着半空，他双腿都不听使唤了，想倒退却僵在那里。</div><div style=\"text-align: justify;\">　　“有一团黑影，在那里，我看到了！”</div><div style=\"text-align: justify;\">　　“那是什么？”</div><div style=\"text-align: justify;\">　　早先被惊吓住的两人，此时也抬头，跟那人一般声音发颤，接着身体踉跄着，快速向后倒退，被吓到浑身发抖。</div><div style=\"text-align: justify;\">　　这一刻，车中无法宁静了，人们听到了外面的声音，一些女人顿时尖叫出声，一片慌乱。</div>', '2018-06-06');
INSERT INTO `chapter` VALUES ('45', '1', '第十章 剧变', '<div style=\"text-align: justify;\">大雾弥漫，半空中垂挂着一道又一道手臂粗的藤蔓，影影绰绰，被雾霭所阻，看不真切。</div><div style=\"text-align: justify;\">　　一颗非常沉重的卫星，被许多藤蔓缠绕着，坠落在列车上，此地无声无息，死一般的寂静。</div><div style=\"text-align: justify;\">　　这个场面实在有些冲击人的眼球，那可是一颗卫星啊，应该在太空中，在既定的轨道上运行，它怎么坠落下来了？！</div><div style=\"text-align: justify;\">　　楚风与周全的脊背都有些凉意，感觉阵阵寒冷，不自禁的再次仰望灰暗的高空，那里有什么？</div><div style=\"text-align: justify;\">　　“不要告诉我，这些藤蔓真的是从天穹上垂落下来的！”周全的声音有些沙哑，面色非常不好看。</div><div style=\"text-align: justify;\">　　这个场面实在令他有些难以接受，不敢相信！</div>', '2018-06-06');
INSERT INTO `chapter` VALUES ('46', '1', '第十一章 到家', '<div style=\"text-align: justify;\">周全面色古怪，似乎有些纠结，有些扭捏，碰了碰楚风，小声道：“你说那人长出一对银翅，能否翱翔于天穹上？”</div><div style=\"text-align: justify;\">　　“有可能。”楚风点头，而后觉得有些好笑，道：“又不是你长了翅膀，你扭捏什么？”</div><div style=\"text-align: justify;\">　　“我不是也有一颗鲜红的果实吗？”周胖子小心翼翼，将背包打开，早先挖到的那株草还在，以透明的袋子裹着，从而也隔绝了香气弥漫。</div><div style=\"text-align: justify;\">　　在那株草上，结有一颗通红的果实，拳头那么大，晶莹如红玛瑙似的，稍微打开袋子，顿时溢出浓郁的芬芳。</div><div style=\"text-align: justify;\">　　“你说，我如果吃掉的话，会不会也长出什么？”胖子怀疑，非常纠结。</div><div style=\"text-align: justify;\">　　这一次，楚风没有笑，而是神色郑重，早先如果不知道也就罢了，现在看来这种异变的植物生出的果实非同寻常。</div>', '2018-06-06');
INSERT INTO `chapter` VALUES ('47', '1', '第十二章 太行神山', '<div style=\"text-align: justify;\">深夜，太行山脉中隆隆声不绝，成百上千座巍峨大山拔地而起，凭空出现，非常壮阔。</div><div style=\"text-align: justify;\">　　有的山峰高逾千丈，宛若抵天神剑，刺向天宇，立上立下，极度陡峭，险不可攀。</div><div style=\"text-align: justify;\">　　有的大山恢宏而雄浑，整体庞大，如同神话中的太古魔牛，带着莽荒气息，横陈在那里，高能有万米。</div><div style=\"text-align: justify;\">　　在一些山体上，银瀑垂挂，远远望去，在月光下如同一道又一道匹练般，氤氲蒸腾，灵气浓郁。</div><div style=\"text-align: justify;\">　　“这还是我认识的太行山脉吗？”周全震撼莫名，快咬破嘴唇了，确信这不是在睡梦中。</div><div style=\"text-align: justify;\">　　变化过剧，天翻地覆！</div><div style=\"text-align: justify;\">　　那些奇景让人瞠目结舌，难以置信。</div><div style=\"text-align: justify;\">　　楚风发呆，他也有些失神。</div>', '2018-06-06');
INSERT INTO `chapter` VALUES ('48', '1', '第十三章 不属于此界', '<div style=\"text-align: justify;\">楚风摇头，他不同意。</div><div style=\"text-align: justify;\">　　这头小牛虽然只有一米高，还算是个牛犊子，但绝对不简单，贸然冲过去可能会有危险。</div><div style=\"text-align: justify;\">　　皎洁月光下，山林中。</div><div style=\"text-align: justify;\">　　金色小牛很兴奋，成功闯出来以后，它扭了扭头，又甩了甩尾巴，随即一蹦老高，发出“哞”的一声低吼。</div><div style=\"text-align: justify;\">　　山林中有许多草木，不少都结有花朵。</div><div style=\"text-align: justify;\">　　金色的小牛见到后，一阵紧张，它收敛兴奋，小心翼翼的接近，竟然如临大敌，显然它觉得自己还没有彻底摆脱危局。</div><div style=\"text-align: justify;\">　　它慢慢挪步，黄金蹄子落下时很轻，接近一簇山藤花时，浅浅地吸了一口，而后站在原地不动。</div><div style=\"text-align: justify;\">　　一对短小的犄角发出金色光泽，它确信自身无恙，而后再次迈开蹄子，向着有更多草木的地方走去。</div><div style=\"text-align: justify;\">　　“花粉，触媒。”楚风若有所思。</div><div style=\"text-align: justify;\">　　他看的清楚，小牛在吞花粉，像是在试探着什么，十分紧张，它转了一大圈，触及了诸多山花。</div>', '2018-06-06');
INSERT INTO `chapter` VALUES ('49', '20', '第一章 远古神墓', '<div style=\"text-align: justify;\">穿越了宇宙洪荒，凝练了天地玄黄……纵使摆脱了六道轮回，也难逃那天地动荡……</div><div style=\"text-align: justify;\">　　神魔陵园位于天元大陆中部地带，整片陵园除了安葬着人类历代的最强者、异类中的顶级修炼者外，其余每一座坟墓都埋葬着一位远古的神或魔，这是一片属于神魔的安息之地。</div><div style=\"text-align: justify;\">　　陵园内绿草如茵，鲜花芬芳，如果没有那成片的碑林，称之为花园也不为过。陵园外围是高大的雪枫树，惟神魔陵园特有，相传为已逝神魔灵气所化。</div><div style=\"text-align: justify;\">　　雪枫树碧绿的枝叶郁郁葱葱，随着微风轻轻摇曳，仿佛在追忆那昔日的辉煌，雪白的花瓣洁白无暇，如雪花一般在空中漫漫飘洒，这是神灵的眼泪，似在诉说那曾经的悲伤。</div>', '2018-06-06');
INSERT INTO `chapter` VALUES ('50', '19', '第一章 星空中的青铜巨棺', '<div style=\"text-align: justify;\">生命是世间最伟大的奇迹。</div><div style=\"text-align: justify;\">　　四方上下曰宇。宇虽有实，而无定处可求。往古来今曰宙。宙虽有增长，不知其始之所至。</div><div style=\"text-align: justify;\">　　浩瀚的宇宙，无垠的星空，许多科学家推测，地球可能是唯一的生命源地。</div><div style=\"text-align: justify;\">　　人类其实很孤独。在苍茫的天宇中，虽然有亿万星辰，但是却很难寻到第二颗生命源星。</div><div style=\"text-align: justify;\">　　不过人类从来没有放弃过探索，自上世纪以来已经发射诸多太空探测器。</div><div style=\"text-align: justify;\">　　旅行者二号是一艘无人外太空探测器，于一九七七年在美国肯尼迪航天中心发射升空。</div><div style=\"text-align: justify;\">　　它上面携带着一张主题为“向宇宙致意”的镀金唱片，里面包含一些流行音乐和用地球五十五种语言录制的问候辞，以冀有一天被可能存在的外星文明拦截和收到。</div><div style=\"text-align: justify;\">　　从上世纪七十年代到现在，旅行者二号一直在孤独的旅行，在茫茫宇宙中它如一粒尘埃般渺小。</div><div style=\"text-align: justify;\">　　同时代的外太空探测器，大多或已经发生故障，或已经中断讯号联系，永远的消失在了枯寂的宇宙中。</div><div style=\"text-align: justify;\">　　三十几年过去了，科技在不断发展，人类已经研制出更加先进的外太空探测器，也许不久的将来对星空的探索会取得更进一步的发展。</div><div style=\"text-align: justify;\">　　但纵然如此，在相当长的时间内，新型外太空探测器依然无法追上旅行者二号的步伐。</div><div style=\"text-align: justify;\">　　三十三年过去了，旅行者二号距离地球已经有一百四十亿公里。</div><div style=\"text-align: justify;\">　　此时此刻，它已经达到第三宇宙速度，轨道再也不能引导其飞返太阳系，成为了一艘星际太空船。</div><div style=\"text-align: justify;\">　　黑暗与冰冷的宇宙中，星辰点点，犹如一颗颗晶莹的钻石镶嵌在黑幕上。</div><div style=\"text-align: justify;\">　　旅行者二号太空探测器虽然正在极速飞行，但是在幽冷与无垠的宇宙中却像是一只小小的蚁虫在黑暗的大地上缓缓爬行。</div><div style=\"text-align: justify;\">　　三十多年过去后，就在今日这一刻，旅行者二号有了惊人的发现！</div><div style=\"text-align: justify;\">　　在枯寂的宇宙中，九具庞大的尸体静静的横在那里……</div>', '2018-06-06');
INSERT INTO `chapter` VALUES ('51', '19', '第二章 素问', '<div style=\"text-align: justify;\">“上古之人，春秋皆度百岁，而动作不衰。”叶凡合上《黄帝内经》，对于素问篇所载的上古时代悠然神往。</div><div style=\"text-align: justify;\">　　关于上古时期，并没有详尽而精准的文字记载，对于今人来说那是一段充满了无尽迷雾的古史，让人遐思无限。</div><div style=\"text-align: justify;\">　　清风拂动，院中几株梧桐在轻轻摇曳，繁茂的枝叶发出“簌簌”的声响，清新的空气自窗外迎面吹来。</div><div style=\"text-align: justify;\">　　叶凡很喜欢看“搜奇”类的书籍，泡上一杯清淡的绿茶，他开始继续翻看手中的古籍。</div><div style=\"text-align: justify;\">　　“凡人皆可活过百岁，而行动并无衰老迹象。上古时期，这是怎样的一段神秘古史……”</div><div style=\"text-align: justify;\">　　对于素问篇所载的古人年岁问题，作为现代人他自然不会相信。他所好奇的只是古人所向往的那个“上古”时代为何在很多古籍中都隐晦的提到过，似乎有一段笼罩着无尽迷雾的上古文明消失在了历史长河中。</div>', '2018-06-06');
INSERT INTO `chapter` VALUES ('52', '21', '第一章 降临《格格巫与蓝精灵》', '<div style=\"text-align: justify;\">喜欢无限类，电影降临类小说的人，谁没叶公好龙一般，幻想过自己有一天，去那些耳熟能闻的世界大杀四方。</div><div style=\"text-align: justify;\">　　不过，叶公好龙就是叶公好龙，就像是见到真龙后，叶公会被直接吓傻一样。如果真有这种选择出现，一百个人铭心自问，最少得有八十人被吓出一身冷汗。</div><div style=\"text-align: justify;\">　　所以，现在的吴明感觉就很冷，因为他手中正拿着一枚铜色胸章，脑海中不断回荡着一段对话。</div><div style=\"text-align: justify;\">　　“恭喜宿主，你已被赏金猎人系统选中，欢迎您加入到赏金猎人的行列，开启诸天世界的狩猎之旅。现在，请您闭目沉思，自主挑选您要接取的任务，并去完成它。”</div>', '2018-06-06');
INSERT INTO `chapter` VALUES ('53', '18', '第一章 横空出世', '<div style=\"text-align: justify;\">九国大战已经过去了二十多年余下的清风、拜月、汉唐、无双和新明五国经过多年的休养生息已经元气大复。大6百废具兴一片歌舞升平的繁荣景象。</div><div style=\"text-align: justify;\">长生谷位于汉唐帝国境内一年四季谷内始终郁郁葱葱充满生气。</div><div style=\"text-align: justify;\">这里有一个古老的传说相传远古时期长生谷内住着一个盖代魔君此君一身出神入化的武功纵横大6傲视当代难逢抗手。</div><div style=\"text-align: justify;\">不知为何魔君触怒了仙人一场仙魔大战在谷内展开。魔君不愧为天纵奇才居然将**凡胎修到了仙魔之境强横的实力另仙人都感到难以招架。</div><div style=\"text-align: justify;\">大战持续了三天三夜结果如何无人得知。很久以后谷外居民才敢进来观看只见谷内满目疮痍地上到处是残枝败叶兽骨堆积如山。此后数十年谷内寸草不生无丝毫生机一片死寂。</div><div style=\"text-align: justify;\">大约又过了百年的光阴谷内才慢慢的恢复了生机重现了长生谷内一年四季郁郁葱葱、生气勃勃的景象。</div>', '2018-06-06');

-- ----------------------------
-- Table structure for count
-- ----------------------------
DROP TABLE IF EXISTS `count`;
CREATE TABLE `count` (
  `bid` int(11) NOT NULL,
  `accessCount` int(11) unsigned zerofill NOT NULL DEFAULT '00000000000',
  `replyCount` int(11) unsigned zerofill NOT NULL DEFAULT '00000000000',
  PRIMARY KEY (`bid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=REDUNDANT;

-- ----------------------------
-- Records of count
-- ----------------------------
INSERT INTO `count` VALUES ('1', '00000000931', '00000000002');
INSERT INTO `count` VALUES ('5', '00000000002', '00000000000');
INSERT INTO `count` VALUES ('15', '00000000026', '00000000000');
INSERT INTO `count` VALUES ('4', '00000000161', '00000000003');
INSERT INTO `count` VALUES ('6', '00000000760', '00000000000');
INSERT INTO `count` VALUES ('14', '00000002083', '00000000000');
INSERT INTO `count` VALUES ('16', '00000000013', '00000000000');
INSERT INTO `count` VALUES ('17', '00000000013', '00000000000');
INSERT INTO `count` VALUES ('18', '00000000010', '00000000000');
INSERT INTO `count` VALUES ('19', '00000000012', '00000000000');
INSERT INTO `count` VALUES ('20', '00000000011', '00000000000');
INSERT INTO `count` VALUES ('21', '00000000016', '00000000000');
INSERT INTO `count` VALUES ('22', '00000000000', '00000000000');

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `replyid` int(11) NOT NULL AUTO_INCREMENT,
  `bid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `replycontents` varchar(1000) DEFAULT NULL,
  `replytime` datetime DEFAULT NULL,
  `replyip` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`replyid`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('15', '0', '10', '2413412', '2018-06-06 01:30:16', '127.0.0.1');
INSERT INTO `reply` VALUES ('16', '1', '10', '23', '2018-06-06 01:32:45', '127.0.0.1');
INSERT INTO `reply` VALUES ('17', '1', '10', '3423', '2018-06-06 01:33:02', '127.0.0.1');
INSERT INTO `reply` VALUES ('18', '1', '5', '22', '2018-06-06 01:34:21', '127.0.0.1');
INSERT INTO `reply` VALUES ('19', '21', '5', 'qw4q234', '2018-06-06 14:05:00', '127.0.0.1');
INSERT INTO `reply` VALUES ('8', '1', '5', '11', '2018-05-04 09:56:35', '0:0:0:0:0:0:0:1');
INSERT INTO `reply` VALUES ('9', '1', '5', '22', '2018-05-04 09:56:42', '0:0:0:0:0:0:0:1');
INSERT INTO `reply` VALUES ('14', '0', '10', '2哦2', '2018-06-06 01:30:06', '127.0.0.1');
INSERT INTO `reply` VALUES ('11', '4', '5', '小说评论1', '2018-05-20 15:30:58', '0:0:0:0:0:0:0:1');
INSERT INTO `reply` VALUES ('12', '4', '5', '小说评论2', '2018-05-20 15:31:34', '0:0:0:0:0:0:0:1');
INSERT INTO `reply` VALUES ('13', '6', '5', '12324', '2018-05-29 19:36:42', '0:0:0:0:0:0:0:1');

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `rid` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `bid` int(11) NOT NULL DEFAULT '0',
  `bookname` varchar(30) DEFAULT NULL,
  `bookintroduction` varchar(200) DEFAULT NULL,
  `bookSampleDraft` varchar(500) DEFAULT NULL,
  `reviewStatus` varchar(30) NOT NULL DEFAULT 'nopass',
  `applyTime` datetime DEFAULT NULL,
  `postip` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of review
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  `role` varchar(30) NOT NULL DEFAULT 'reader',
  `sex` varchar(10) NOT NULL,
  `hobbys` varchar(50) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `createtime` date NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('13', 'ack', '123', 'reader', '男', '文学,影视', '2018-06-06', '济南', 'ack@qq.com', '412341234', '2018-06-02');
INSERT INTO `user` VALUES ('3', 'mark', '123', 'author', '男', '文学,音乐', '1998-04-14', '北京', 'cd@163.com', '314341234', '2018-04-14');
INSERT INTO `user` VALUES ('4', 'anw', '123', 'reader', '男', '文学,体育', '2001-04-14', '武汉', 'lsyx@qq.com', '412341234', '2018-04-14');
INSERT INTO `user` VALUES ('5', 'tom', '123', 'author', '男', '文学,影视', '2018-05-25', '济南', 'tom@gmail.com', '53453245', '2018-04-14');
INSERT INTO `user` VALUES ('6', 'alice', '123', 'reader', '男', '文学,影视', '1985-05-03', '济南', 'alice@qq.com', '4352345', '2018-05-03');
INSERT INTO `user` VALUES ('7', 'ali', '123', 'author', '男', '影视,音乐', '1996-05-03', '济南', 'ali@qq.com', '412412', '2018-05-03');
INSERT INTO `user` VALUES ('9', '七夜', '123', 'author', '女', '文学,影视,音乐', '1981-05-04', '武汉', 'qy@qxs.com', '42345523', '2018-05-04');
INSERT INTO `user` VALUES ('10', '辰东', '123', 'author', '男', '文学,影视', '1986-05-09', '济南', 'chdong@qxs.com', '6745523', '2018-05-09');
INSERT INTO `user` VALUES ('11', '龙升云霄', '123', 'author', '男', '文学,影视', '1982-05-05', '上海', 'lsyx@qxs.com', '4235435', '2018-05-18');
INSERT INTO `user` VALUES ('12', 'admin', '123', 'author', '男', '文学,音乐,体育', '1999-03-17', '深圳', 'admin@qiuxiaoshuo.com', '1324232', '2018-05-17');

-- ----------------------------
-- Table structure for user_vote
-- ----------------------------
DROP TABLE IF EXISTS `user_vote`;
CREATE TABLE `user_vote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `bid` int(11) DEFAULT NULL,
  `voteTime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_vote
-- ----------------------------
INSERT INTO `user_vote` VALUES ('21', '5', '16', '2018-06-06');
INSERT INTO `user_vote` VALUES ('22', '7', '15', '2018-06-06');
INSERT INTO `user_vote` VALUES ('23', '5', '19', '2018-06-06');

-- ----------------------------
-- Table structure for vote
-- ----------------------------
DROP TABLE IF EXISTS `vote`;
CREATE TABLE `vote` (
  `vid` int(11) NOT NULL AUTO_INCREMENT,
  `bid` int(11) DEFAULT NULL,
  `voteCount` int(20) unsigned zerofill NOT NULL DEFAULT '00000000000000000000',
  PRIMARY KEY (`vid`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vote
-- ----------------------------
INSERT INTO `vote` VALUES ('1', '1', '00000000000000000024');
INSERT INTO `vote` VALUES ('15', '5', '00000000000000000000');
INSERT INTO `vote` VALUES ('16', '15', '00000000000000000002');
INSERT INTO `vote` VALUES ('4', '4', '00000000000000000055');
INSERT INTO `vote` VALUES ('5', '6', '00000000000000000002');
INSERT INTO `vote` VALUES ('6', '14', '00000000000000000002');
INSERT INTO `vote` VALUES ('17', '16', '00000000000000000002');
INSERT INTO `vote` VALUES ('18', '17', '00000000000000000001');
INSERT INTO `vote` VALUES ('19', '18', '00000000000000000001');
INSERT INTO `vote` VALUES ('20', '19', '00000000000000000002');
INSERT INTO `vote` VALUES ('21', '20', '00000000000000000001');
INSERT INTO `vote` VALUES ('22', '21', '00000000000000000001');
INSERT INTO `vote` VALUES ('23', '22', '00000000000000000000');
DROP TRIGGER IF EXISTS `replyCountUpdate`;
DELIMITER ;;
CREATE TRIGGER `replyCountUpdate` AFTER INSERT ON `reply` FOR EACH ROW begin
    update  t_count set replyCount=replyCount+1  where  t_count.msgid=new.msgid;
end
;;
DELIMITER ;
