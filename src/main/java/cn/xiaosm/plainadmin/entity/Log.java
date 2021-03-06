/**
 * Copyright: 2019-2020，小树苗(www.xiaosm.cn)
 * FileName: Operator
 * Author:   Young
 * Date:     2020/6/16 10:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * Young         修改时间           版本号             描述
 */
package cn.xiaosm.plainadmin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author Young
 * @create 2020/6/16
 * @since 1.0.0
 */
@Data
@Accessors(chain = true)
@TableName("log")
public class Log implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String content;
    private String error;
    private String type;
    private String method;
    private String ip;
    private Integer time;
    private Integer userId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

}