package com.awl.jspbook.ch14;

import javax.servlet.jsp.tagext.*;

public class TrackTagExtraInfo extends TagExtraInfo {
    public VariableInfo[] getVariableInfo(TagData data) {
        return new VariableInfo[] 
            {
                new VariableInfo("name",
                                 "String",
                                 true,
                                 VariableInfo.NESTED),

                new VariableInfo("length",
                                 "Integer",
                                 true,
                                 VariableInfo.NESTED)
            };
    }
}

        
