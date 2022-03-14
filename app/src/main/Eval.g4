grammar Eval;
/** 起始规则 语法分析器起点 */
expr:	expr op=(MUL|DIV) expr # MulDiv
    |	expr op=(ADD|SUB) expr # AddSub
    |	NUM                    # Num
    |	INT                    # Int
    |	'(' expr ')'           # Parens
    ;

INT     : '0' | [1-9][0-9]* ; // 匹配整数
DOT     : '.'               ; // 小数点
NUM     : INT DOT INT
        | INT DOT
        | DOT INT
        ;
NEWLINE : [\r\n]+ ;           // 新行 即语句终止标志
WS      : [ \t]+ -> skip ;    // 丢弃空白字符

MUL     : '*' ;
DIV     : '/' ;
ADD     : '+' ;
SUB     : '-' ;
