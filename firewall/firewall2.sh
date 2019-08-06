#script de firewall básico

#Objetivo: permitir que los equipos de la intranet puedan hacer uso de Internet mediante NAT por dirección de Origen
#permitir que desde Internet se pueda acceder a nuestro servidor Web (Elementary) que esta en la Intranet


internet=enp0s8     # ajustar con la id del dispositivo. Al dar ifconfig la interfaz que tenga la ip 192.168.30.x 
intranet=enp0s3     # ajustar con la id del dispositivo. Al dar ifconfig la interfaz que tenga la ip de intranet
IpWeb=192.168.0.50  #ajustar dirección Ip del equipo de la intranet (ELEMENTARY)
PuertoServer=80     #puerto donde escucha el servidor Web 
PuertoInternet=8080 #puerto a donde nos conectaremos desde afuera de la intranet usando la IP pública

#habilitar routing
echo 1 > /proc/sys/net/ipv4/ip_forward

#Limpieza de reglas anteriores
iptables -F     # borrar reglas de filtrado
iptables -t nat -F  #: borrar reglas de NAT
iptables -X   #: borrar cadenas de usuario
iptables -X  -t nat #: borrar cadenas de usuario


#Definir las políticas  por defecto
#Se está bloqueando todo lo entrante
iptables -P INPUT DROP #:no se permite ningún paquete entrante
iptables -P OUTPUT ACCEPT #: se permite la salida de cualquier paquete
iptables -P FORWARD DROP #: no se permite enrutar ningún paquete

#Se perminate que las respuestas a solicitudes previas desde el firewall entren
iptables -A INPUT -m state --state ESTABLISHED,RELATED -j  ACCEPT

#Se permiter conexiones del firewall con el firewall a traves de la interfaz de loopbak
iptables -A INPUT -i lo -j ACCEPT

#Se permiten conexiones de la intranet hacia el firewall
iptables -A INPUT -i $intranet -j ACCEPT

#Desactivar las siguientes linea con #
#iptables -A INPUT -p tcp --dport 80 -j ACCEPT
#iptables -A INPUT -p tcp --dport 22 -j ACCEPT

#Se permiten paquetes de respuesta a solicitudes hechas desde la intranet
iptables -A FORWARD -i $internet -m state --state ESTABLISHED,RELATED -j  ACCEPT

#Regla para nat por dirección de origen SNAT
#A los paquetes salientes por la interfaz de internet se les cambia la IP de origen por la del Firewall

iptables -t nat -A POSTROUTING -o $internet -j MASQUERADE

#Regla de NAT por dirección del destino
#Las solicitutes de conexión diregidas a el puerto que se publique en el firewall 
#se redireccionan al servidor que la atendera en la intranet 
iptables -t nat -A PREROUTING -i $internet -p tcp --dport $PuertoInternet -j DNAT --to  $IpWeb:$PuertoServer 

#Se permite el acceso desde internet al puerto donde se atiende el servicio
iptables -A FORWARD -i $internet -p tcp --dport $PuertoServer -j ACCEPT

#Se permite que los equipos de la intrabet sea enrutados por el firewall
iptables -A FORWARD -i $intranet -j ACCEPT
