package cn.edu.lingnan.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class TagExample01 extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().println("Hello Tag 2022-05-11");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;//跳过标签体，因为根本没有
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;//不跳过页面，继续执行标签之后的内容
    }
}
