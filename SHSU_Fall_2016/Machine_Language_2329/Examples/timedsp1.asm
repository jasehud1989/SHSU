;program that displays the current time
	org 	100h
	section .data
TIME_BUF        DB      '00:00:00$'     ;time buffer hr:min:sec

	section .text
Start:

;get and display time
	mov     BX,TIME_BUF     ;BX points to TIME_BUF
	call    GET_TIME        ;put current time in TIME_BUF
	mov     DX,TIME_BUF     ;DX points  to TIME_BUF
	mov     AH,09h          ;display time
	int     21h
;exit
	mov     AH,4Ch          ;return
	int     21h             ;to DOS

; procedure GET_TIME 
;get time of day and store ASCII digits in time buffer
;input:  BX = address of time buffer
GET_TIME:
	mov     AH,2Ch          ;gettime
	int     21h             ;CH = hr, CL =  min, DH = sec
;convert hours into ASCII and store
	mov     AL,CH           ;hour
	call    CONVERT         ;convert to ASCII
	mov     [BX],AX         ;store
;convert minutes into ASCII and store
	mov     AL,CL           ;minute
	call    CONVERT         ;convert to ASCII
	mov     [BX+3],AX       ;store
;convert seconds into ASCII and store
	mov     AL,DH           ;second
	call    CONVERT         ;convert to ASCII
	mov     [BX+6],AX       ;store
	ret


; procedure CONVERT
;converts byte number (0-59) into ASCII digits
;input:  AL = number
;output: AX = ASCII digits, AL = high digit, AH = low digit
CONVERT:
	mov     AH,0            ;clear AH
	mov     DL,10           ;divide AX by 10
	div     DL              ;AH has remainder, AL has quotient
	or      AX,3030h        ;convert to ASCII, AH has low digit
	ret                     