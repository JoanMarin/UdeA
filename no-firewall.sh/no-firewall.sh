#Desactivación del firewall en linux

#borrar reglas previas
iptables -F

#borrar reglas previas de NAT
iptables -F -t nat
iptables -X

#Politicas por defecto permisivas
iptables -P INPUT         ACCEPT
iptables -P FORWARD  ACCEPT
iptables -P OUTPUT     ACCEPT
iptables-save > /etc/sysconfig/iptables
