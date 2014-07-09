.class public tests
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
	.limit stack 	512
	.limit locals 	512

	iconst_0
	istore 1
	iconst_0
	istore 2
	iconst_0
	istore 3

	invokestatic tests/readInteger()I
	istore		2
	invokestatic tests/readInteger()I
	istore		3


	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload		2
	invokevirtual java/io/PrintStream/println(I)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload		3
	invokevirtual java/io/PrintStream/println(I)V

	ldc 		16
	ldc 		2
	ldc 		8
	ineg
	imul
	iadd
	dup
	istore		3
	pop

	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload		2
	iload		3
	if_icmplt			LBL0
	iconst_0
	goto			LBL1
	LBL0:
	iconst_1
	LBL1:

	iconst_1
	if_icmpeq 		LBL4
	iconst_0
	goto			LBL6
	LBL4:
	ldc 		1
	ldc 		2
	if_icmple			LBL2
	iconst_0
	goto			LBL3
	LBL2:
	iconst_1
	LBL3:

	iconst_1
	if_icmpeq		LBL5	
	iconst_0
	goto			LBL6
	LBL5:
	iconst_1
	LBL6:
	invokevirtual java/io/PrintStream/println(Z)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 		1
	ldc 		2
	imul
	iload		3
	iload		2
	isub
	if_icmpgt			LBL7
	iconst_0
	goto			LBL8
	LBL7:
	iconst_1
	LBL8:

	invokevirtual java/io/PrintStream/println(Z)V

	iload		2
	invokestatic tests/readInteger()I
	dup
	istore		3
	if_icmplt			LBL9
	iconst_0
	goto			LBLa
	LBL9:
	iconst_1
	LBLa:

	iconst_1
	if_icmpeq 		LBLd
	iconst_0
	goto			LBLf
	LBLd:
	ldc 		1
	ldc 		2
	if_icmple			LBLb
	iconst_0
	goto			LBLc
	LBLb:
	iconst_1
	LBLc:

	iconst_1
	if_icmpeq		LBLe	
	iconst_0
	goto			LBLf
	LBLe:
	iconst_1
	LBLf:
	pop
	iload		3
	dup
	getstatic java/lang/System/out Ljava/io/PrintStream;
	swap
	invokevirtual java/io/PrintStream/println(I)V
	ldc 		1
	iadd
	dup
	istore		3
	ldc 		1
	iadd
	dup
	istore		1
	pop

	iconst_0
	istore 2
	iconst_0
	istore 3
	invokestatic tests/readBoolean()Z
	dup
	istore		3
	pop
	iload		3
	dup
	getstatic java/lang/System/out Ljava/io/PrintStream;
	swap
	invokevirtual java/io/PrintStream/println(Z)V
	pop
	ldc 		12
	ldc 		5
	idiv
	ldc 		5
	imul
	ldc 		12
	ldc 		5
	irem
	iadd
	ldc 		12
	if_icmpeq			LBLg
	iconst_0
	goto			LBLh
	LBLg:
	iconst_1
	LBLh:

	iconst_1
	if_icmpeq 		LBLk
	iconst_0
	goto			LBLm
	LBLk:
	ldc 		6
	ldc 		6
	if_icmpge			LBLi
	iconst_0
	goto			LBLj
	LBLi:
	iconst_1
	LBLj:

	iconst_1
	if_icmpeq		LBLl	
	iconst_0
	goto			LBLm
	LBLl:
	iconst_1
	LBLm:
	dup
	istore		3
	pop
	iconst_0
	iconst_1
	ixor
	iconst_1
	if_icmpeq 		LBLp
	iconst_0
	goto			LBLr
	LBLp:
	iload		3
	ldc 		1
	if_icmpeq			LBLn
	iconst_0
	goto			LBLo
	LBLn:
	iconst_1
	LBLo:

	iconst_1
	if_icmpeq		LBLq	
	iconst_0
	goto			LBLr
	LBLq:
	iconst_1
	LBLr:
	iconst_1
	if_icmpne		LBLu
	iconst_1
	goto			LBLw
	LBLu:
	iconst_1
	iconst_0
	if_icmpne			LBLs
	iconst_0
	goto			LBLt
	LBLs:
	iconst_1
	LBLt:

	iconst_1
	if_icmpne		LBLv
	iconst_1
	goto			LBLw
	LBLv:
	iconst_0
	LBLw:
	dup
	getstatic java/lang/System/out Ljava/io/PrintStream;
	swap
	invokevirtual java/io/PrintStream/println(Z)V
	iconst_1
	if_icmpeq 		LBLx
	iconst_0
	goto			LBLz
	LBLx:
	iconst_1
	iconst_1
	if_icmpeq		LBLy	
	iconst_0
	goto			LBLz
	LBLy:
	iconst_1
	LBLz:
	dup
	istore		2
	pop

	iconst_0
	istore 3
	iconst_0
	istore 4
	iconst_0
	istore 5
	invokestatic tests/readChar()C
	dup
	istore		4
	pop
	ldc 		122
	dup
	istore		5
	pop

	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 		97
	invokevirtual java/io/PrintStream/println(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload		4
	ldc 		99
	if_icmpeq			LBL10
	iconst_0
	goto			LBL11
	LBL10:
	iconst_1
	LBL11:

	iconst_1
	if_icmpeq 		LBL17
	iconst_0
	goto			LBL19
	LBL17:
	iload		5
	ldc 		98
	if_icmpne			LBL12
	iconst_0
	goto			LBL13
	LBL12:
	iconst_1
	LBL13:

	iconst_1
	if_icmpne		LBL14
	iconst_1
	goto			LBL16
	LBL14:
	iconst_1
	iconst_1
	ixor
	iconst_1
	if_icmpne		LBL15
	iconst_1
	goto			LBL16
	LBL15:
	iconst_0
	LBL16:
	iconst_1
	if_icmpeq		LBL18	
	iconst_0
	goto			LBL19
	LBL18:
	iconst_1
	LBL19:
	invokevirtual java/io/PrintStream/println(Z)V

	ldc 		98
	dup
	istore		3
	pop

	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload		1
	invokevirtual java/io/PrintStream/println(I)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload		2
	invokevirtual java/io/PrintStream/println(Z)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload		3
	invokevirtual java/io/PrintStream/println(C)V



	return
.end method

.method                  private static readInteger()I
   .limit stack          1
   .limit locals         1
   .line                 12
LABEL0x0:
   invokestatic          tests/readLine()Ljava/lang/String;
   invokestatic          java/lang/Integer/parseInt(Ljava/lang/String;)I
LABEL0x6:
   ireturn               
   .line                 13
LABEL0x7:
   astore_0              
   .line                 14
   iconst_0              
   ireturn               
   .catch                java/lang/NumberFormatException from LABEL0x0 to LABEL0x6 using LABEL0x7
.end method              

.method                  private static readLine()Ljava/lang/String;
   .limit stack          5
   .limit locals         2
   .line                 19
   new                   java/io/BufferedReader
   dup                   
   new                   java/io/InputStreamReader
   dup                   
   getstatic             java/lang/System/in Ljava/io/InputStream;
   invokespecial         java/io/InputStreamReader/<init>(Ljava/io/InputStream;)V
   invokespecial         java/io/BufferedReader/<init>(Ljava/io/Reader;)V
   astore_0              
   .line                 21
LABEL0x12:
   aload_0               
   invokevirtual         java/io/BufferedReader/readLine()Ljava/lang/String;
LABEL0x16:
   areturn               
   .line                 22
LABEL0x17:
   astore_1              
   .line                 23
   ldc                   ""
   areturn               
   .catch                java/io/IOException from LABEL0x12 to LABEL0x16 using LABEL0x17
.end method

.method                  private static readChar()C
   .limit stack          2
   .limit locals         1
   .line                 29
   invokestatic          tests/readLine()Ljava/lang/String;
   astore_0              
   .line                 30
   aload_0               
   invokevirtual         java/lang/String/length()I
   ifle                  LABEL0x13
   aload_0               
   iconst_0              
   invokevirtual         java/lang/String/charAt(I)C
   goto                  LABEL0x14
LABEL0x13:
   iconst_0              
LABEL0x14:
   ireturn               
.end method              

.method                  private static readBoolean()Z
   .limit stack          2
   .limit locals         1
   .line                 34
   invokestatic          tests/readLine()Ljava/lang/String;
   invokevirtual         java/lang/String/toLowerCase()Ljava/lang/String;
   astore_0              
   .line                 35
   aload_0               
   ldc                   "true"
   invokevirtual         java/lang/String/equals(Ljava/lang/Object;)Z
   ireturn               
.end method                        
              