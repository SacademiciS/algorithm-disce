package creation.builder.achieve;

import creation.builder.ceilling.LevelOneCeiling;
import creation.builder.ceilling.LevelTwoCeiling;
import creation.builder.coat.DuluxCoat;
import creation.builder.coat.LiBangCoat;
import creation.builder.floor.ShengXiangFloor;
import creation.builder.tile.DongPengTile;
import creation.builder.tile.MarcoPoloTile;

//建造者的使用中就已经非常容易了，统一的建造方式，通过不同物料填充出不同的装修风格；豪华欧式、轻奢田园、现代简约，
//如果将来业务扩展也可以将这部分内容配置到数据库自动生成。但整体的思想还可以使用创建者模式进行搭建。
public class Builder {

    public IMenu levelOne(Double area) {
        return new DecorationPackageMenu(area, "豪华欧式")
                .appendCeiling(new LevelTwoCeiling())   // 吊顶，二级顶
                .appendCoat(new DuluxCoat())            // 涂料，多乐士
                .appendFloor(new ShengXiangFloor());    // 地板，圣象
    }

    public IMenu levelTwo(Double area) {
        return new DecorationPackageMenu(area, "轻奢田园")
                .appendCeiling(new LevelTwoCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new MarcoPoloTile());       // 地砖，马可波罗
    }

    public IMenu levelThree(Double area) {
        return new DecorationPackageMenu(area, "现代简约")
                .appendCeiling(new LevelOneCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new DongPengTile());        // 地砖，东鹏
    }
}
