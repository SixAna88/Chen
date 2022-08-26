package cn.edu.lingnan.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class TagExample03 extends BodyTagSupport {
    private int count;
    private String name;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int doStartTag() throws JspException {

        System.out.println("The doStartTag mothed...");
        if(count>0){
            System.out.println("the count in doStartTag value is "+ count);
            return EVAL_BODY_BUFFERED;
        }
        else
            return SKIP_BODY;
    }

    @Override
    public int doAfterBody() throws JspException {
        System.out.println("The doAfterBody mothed...");
        System.out.println("the count in doAfterTag value is "+ count);
        if(count>1){
            count--;
            return EVAL_BODY_AGAIN;
        }
        else
            return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        System.out.println("The doEndTag mothed...");
        BodyContent bodyContent = getBodyContent();
        if(bodyContent!=null){
            try {
                pageContext.getOut().println("hello "+ name);
                bodyContent.writeOut(bodyContent.getEnclosingWriter());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return EVAL_PAGE;//不跳过页面，继续执行标签之后的内容
    }
}
