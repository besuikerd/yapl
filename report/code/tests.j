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
	iconst_0
	istore 6
	iconst_0
	istore 7
	iconst_0
	istore 8

	invokestatic tests/readChar()C
	istore		5
	invokestatic tests/readChar()C
	istore		6
	invokestatic tests/readChar()C
	istore		7
	invokestatic tests/readChar()C
	istore		8

	ldc 		122
	dup
	istore		4
	pop

	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 		103
	invokevirtual java/io/PrintStream/println(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 		114
	invokevirtual java/io/PrintStream/println(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 		101
	invokevirtual java/io/PrintStream/println(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 		97
	invokevirtual java/io/PrintStream/println(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 		116
	invokevirtual java/io/PrintStream/println(C)V


	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 		97
	invokevirtual java/io/PrintStream/println(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload		5
	ldc 		121
	if_icmpeq			LBL10
	iconst_0
	goto			LBL11
	LBL10:
	iconst_1
	LBL11:

	iconst_1
	if_icmpeq 		LBL14
	iconst_0
	goto			LBL16
	LBL14:
	iload		6
	ldc 		97
	if_icmpeq			LBL12
	iconst_0
	goto			LBL13
	LBL12:
	iconst_1
	LBL13:

	iconst_1
	if_icmpeq		LBL15	
	iconst_0
	goto			LBL16
	LBL15:
	iconst_1
	LBL16:
	iconst_1
	if_icmpeq 		LBL19
	iconst_0
	goto			LBL1b
	LBL19:
	iload		7
	ldc 		112
	if_icmpeq			LBL17
	iconst_0
	goto			LBL18
	LBL17:
	iconst_1
	LBL18:

	iconst_1
	if_icmpeq		LBL1a	
	iconst_0
	goto			LBL1b
	LBL1a:
	iconst_1
	LBL1b:
	iconst_1
	if_icmpeq 		LBL1e
	iconst_0
	goto			LBL1g
	LBL1e:
	iload		8
	ldc 		108
	if_icmpeq			LBL1c
	iconst_0
	goto			LBL1d
	LBL1c:
	iconst_1
	LBL1d:

	iconst_1
	if_icmpeq		LBL1f	
	iconst_0
	goto			LBL1g
	LBL1f:
	iconst_1
	LBL1g:
	invokevirtual java/io/PrintStream/println(Z)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload		4
	ldc 		98
	if_icmpne			LBL1h
	iconst_0
	goto			LBL1i
	LBL1h:
	iconst_1
	LBL1i:

	iconst_1
	if_icmpne		LBL1j
	iconst_1
	goto			LBL1l
	LBL1j:
	iconst_1
	iconst_1
	ixor
	iconst_1
	if_icmpne		LBL1k
	iconst_1
	goto			LBL1l
	LBL1k:
	iconst_0
	LBL1l:
	invokevirtual java/io/PrintStream/println(Z)V

	ldc 		33
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

	iconst_0
	istore 4
	iconst_0
	istore 5
	iload		4
	ldc 		0
	if_icmpeq			LBL1m
	iconst_0
	goto			LBL1n
	LBL1m:
	iconst_1
	LBL1n:

	iconst_1
	if_icmpne LBL1o
	ldc 		4
	dup
	istore		4
	pop
	ldc 		5
	dup
	istore		5
	pop

	LBL1o:

	iconst_0
	istore 6
	invokestatic tests/readBoolean()Z
	dup
	istore		6
	iconst_1
	if_icmpne		LBL1q
	ldc 		1
	goto			LBL1p
	LBL1q:
	ldc 		2
	LBL1p:
	dup
	istore		4
	pop
	iload		4
	ldc 		2
	if_icmpeq			LBL1r
	iconst_0
	goto			LBL1s
	LBL1r:
	iconst_1
	LBL1s:

	iconst_1
	if_icmpne LBL1v
	iconst_0
	istore 7
	invokestatic tests/readBoolean()Z
	dup
	istore		7
	pop
	iload		7
	iconst_1
	if_icmpne		LBL1u
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 		121
	invokevirtual java/io/PrintStream/println(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 		101
	invokevirtual java/io/PrintStream/println(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 		115
	invokevirtual java/io/PrintStream/println(C)V

	goto			LBL1t
	LBL1u:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 		110
	invokevirtual java/io/PrintStream/println(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 		111
	invokevirtual java/io/PrintStream/println(C)V

	LBL1t:

	LBL1v:
	ldc 		0
	dup
	istore		4
	pop
	goto		LBL1y
	LBL1z:
	ldc 		1
	dup
	istore		4
	pop
	ldc 		4
	dup
	istore		5
	pop

	LBL1y:
	iconst_1
	iload		4
	ldc 		1
	if_icmplt			LBL1w
	iconst_0
	goto			LBL1x
	LBL1w:
	iconst_1
	LBL1x:

	if_icmpeq	LBL1z
	invokestatic tests/readInteger()I
	dup
	istore		4
	pop
	invokestatic tests/readInteger()I
	dup
	istore		5
	pop
	goto		LBL22
	LBL23:
	iconst_0
	istore 7
	ldc 		3
	dup
	istore		7
	pop

	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload		4
	invokevirtual java/io/PrintStream/println(I)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload		7
	invokevirtual java/io/PrintStream/println(I)V

	iload		4
	ldc 		1
	isub
	dup
	istore		4
	pop
	LBL22:
	iconst_1
	iload		4
	ldc 		0
	if_icmpgt			LBL20
	iconst_0
	goto			LBL21
	LBL20:
	iconst_1
	LBL21:

	if_icmpeq	LBL23


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
              