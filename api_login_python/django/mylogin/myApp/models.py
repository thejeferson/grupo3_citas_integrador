from django.db import models

# Create your models here.
class Login(models.Model):
    usuario = models.CharField(max_length=30)
    contraseña = models.CharField(max_length=30)